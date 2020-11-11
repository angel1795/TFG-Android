from django.shortcuts import render
from factura.models import Factura, LineaFactura
# Create your views here.
def factura(request, num):
    return render(request, "simple_fact.html", {
    "resultado": Factura.objects.get(pk=num) ,   
    })

def facturas(request):
    total = 0
    
    for i in LineaFactura.objects.all():
        x = i.precio_real()
        total = total + x
        
    return render(request, "facturas.html",{
    "f_result" : Factura.objects.order_by("num").all(),
    "total": total,

    })