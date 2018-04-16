from spyne import Application, rpc, ServiceBase, Iterable, Integer, Unicode, Fault

from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication

class Product():
    def __init__(self, pid, n, p):
        self.productID = pid
        self.name = n
        self.price = p

# the "database"
products = {
    1: Product(1, "Product 1", 1.1),
    2: Product(2, "Product 2", 2.1),
    3: Product(3, "Product 3", 3.1),
    4: Product(4, "Product 4", 4.1),
    5: Product(5, "Product 5", 5.1)
}


class ProductService(ServiceBase):
    @rpc(Unicode, Integer, _returns=Iterable(Unicode))
    def getProduct(ctx, name, pid):
        # get product from id and return data about it here
        yield u'%s' % products[pid].name 
        yield u'%f' % products[pid].price

    @rpc(_returns=Iterable(Unicode))
    def getProductList(ctx):
        for p in products:
            yield u'%s' % products[p].name
            yield u'%f' % products[p].price
            yield u'%d' % products[p].productID

    @rpc(Integer, Integer, _returns=Iterable(Unicode))
    def order(ctx, pid, quantity):
        # get product from id and return data about it here
        try:
            yield u'%s' % products[pid].name
            yield u'%f' % products[pid].price
            yield u'%d' % products[pid].productID

        #except error.Fault, e:
        except error.Fault as e:
            sc = ctx.service_class
            logger.error("Client Error: %r | Request: %r", (e, ctx.in_object))
            raise


application = Application([ProductService], 'spyne.examples.product.soap',in_protocol=Soap11(validator='lxml'),out_protocol=Soap11())
wsgi_application = WsgiApplication(application)


if __name__ == '__main__':
    import logging
    from wsgiref.simple_server import make_server

    logging.basicConfig(level=logging.DEBUG)
    logging.getLogger('spyne.protocol.xml').setLevel(logging.DEBUG)

    logging.info("listening to http://127.0.0.1:8000")
    logging.info("wsdl is at: http://localhost:8000/?wsdl")

    server = make_server('127.0.0.1', 8000, wsgi_application)
    server.serve_forever()
