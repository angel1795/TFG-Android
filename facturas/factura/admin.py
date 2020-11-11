from django.contrib import admin
from factura.models import Factura, LineaFactura



class FacturaAdmin(admin.ModelAdmin):
    list_display = (
        "num",
        "anio",
        "fecha_emision",
        "cliente_nombre",
        "cliente_direccion",
    )

admin.site.register(Factura, FacturaAdmin)

class LineaFacturaAdmin(admin.ModelAdmin):
    list_display = (
        "id_producto",
        "nombre_producto",
        "factura_productos",
        "precio_unitario",
        "unidades",
        "precio_real"

    )

admin.site.register(LineaFactura, LineaFacturaAdmin)