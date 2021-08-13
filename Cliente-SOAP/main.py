# !/usr/bin/env python3
from zeep import Client
import json
# https://www.programcreek.com/python/example/106302/zeep.Client
# https://adriennedomingus.medium.com/using-zeep-to-make-soap-requests-in-python-c575ea0ee954
# https://stackoverflow.com/questions/4917006/string-to-dictionary-in-python


wsdlURL = 'http://localhost:7000/ws/URLWebServices?wsdl'
client = Client(wsdlURL)

print('\t\tCliente SOAP')
print('Log in:')
print('Usuario:')
username = input()
print('Contraseña:')
password = input()

print()
print('********Listado de URLS por el usuario ingresado********')
print(client.service.getListaURLS(username, password))

print()
print('********Acortar una url********')
print('URL:')
url = input()
print(client.service.registrarURL(url, username, password))

