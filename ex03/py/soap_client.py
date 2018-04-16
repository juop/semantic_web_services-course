from suds.client import Client

c = Client('http://localhost:8000/?wsdl')

# test get product
response1 = c.service.getProduct('product name', 1)
#stringArray = [ "Hello, punk", "Hello, nerd" ]
print(response1)

# test get product list
response2 = c.service.getProductList()
print(response2)

# test order (pid, quantity)
response3 = c.service.order(2, 1)
print(response3)
