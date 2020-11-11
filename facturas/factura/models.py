from django.db import models


class Factura(models.Model):
    num = models.AutoField(primary_key=True)
    anio = models.IntegerField()
    fecha_emision = models.DateField(auto_now_add=True)
    cliente_nombre = models.TextField()
    cliente_direccion = models.TextField()

    def __str__(self):
        return (f"{self.num}-{self.fecha_emision}: {self.cliente_nombre}")



class LineaFactura(models.Model):
    id_producto = models.AutoField(primary_key=True)
    nombre_producto = models.TextField()
    #DELETE O PROTECT ¿PORQUE? JUSTIFICA LA RESPUESTA
    #A mi el delete me da error entonces por eso pongo protect
    factura_productos = models.ForeignKey(
        Factura,
        on_delete=models.PROTECT,
        default="DEF",
        related_name="lineas"
        )
    precio_unitario = models.FloatField()
    unidades = models.IntegerField()
    


    def __str__(self):
        return (f"{self.factura_productos}: {self.id_producto} -- {self.unidades}")

    def precio_real(self):
        precioreal = float(self.precio_unitario) * float(self.unidades)
        return precioreal 
    total = 0

    def precio_total(self, i):
        for x in i:
            total += float(x.precio_real)
        return float(total) 