# ecartsvc

### mvn clean install
### tomcat server 9 using jersey and eclipse

Get the list of all the products across all the categories
Get the available stock details across products. This should consider the dummy orders placed and return stocks accordingly.

	URL: http://localhost:8080/ecartsvc/api/products
	Response: [{"category":"Mobiles","color":"Black","company":"Apple","discount":13,"price":70000,"product":"AP1","productdescription":"Some description about AP1","stock":11},{"category":"Mobiles","color":"Grey","company":"Samsung","discount":2,"price":50000,"product":"SP1","productdescription":"Some description about SP1","stock":2},{"category":"Mobiles","color":"Black","company":"MI","discount":9,"price":20000,"product":"MP1","productdescription":"Some description about MP1","stock":35},{"category":"Computers","color":"Grey","company":"Intel","discount":0,"price":67000,"product":"IL1","productdescription":"Some description about IL1","stock":106},{"category":"Computers","color":"Black","company":"Intel","discount":6,"price":74000,"product":"IL2","productdescription":"Some description about IL2","stock":300},{"category":"Computers","color":"Black","company":"Lenovo","discount":10,"price":80000,"product":"LL1","productdescription":"Some description about LL2","stock":138},{"category":"Television","color":"Black","company":"LG","discount":8,"price":42500,"product":"LT1","productdescription":"Some description about LT1","stock":62},{"category":"Television","color":"Grey","company":"Samsung","discount":16,"price":58360,"product":"ST1","productdescription":"Some description about ST1","stock":168}]


Get the list of all the products by category or of a price less than or greater than a specified price for that product

	URL: http://localhost:8080/ecartsvc/api/products-by-category?category=Mobiles
	Response:
	[{"category":"Mobiles","color":"Black","company":"Apple","discount":13,"price":70000,"product":"AP1","productdescription":"Some description about AP1","stock":11},{"category":"Mobiles","color":"Grey","company":"Samsung","discount":2,"price":50000,"product":"SP1","productdescription":"Some description about SP1","stock":2},{"category":"Mobiles","color":"Black","company":"MI","discount":9,"price":20000,"product":"MP1","productdescription":"Some description about MP1","stock":35}]
	
	URL: http://localhost:8080/ecartsvc/api/products-by-category?category=Mobiles&price=50000
	Response:
	[{"category":"Mobiles","color":"Black","company":"Apple","discount":13,"price":70000,"product":"AP1","productdescription":"Some description about AP1","stock":11},{"category":"Mobiles","color":"Black","company":"MI","discount":9,"price":20000,"product":"MP1","productdescription":"Some description about MP1","stock":35}]
	
Get the list of all the products by company or of a price less than or greater than a specified price for that company

	URL: http://localhost:8080/ecartsvc/api/products-by-company?company=Apple
	Response:
	[{"category":"Mobiles","color":"Black","company":"Apple","discount":13,"price":70000,"product":"AP1","productdescription":"Some description about AP1","stock":11}]
	
	URL: http://localhost:8080/ecartsvc/api/products-by-company?company=Apple&price=50000
	Response:
	[{"category":"Mobiles","color":"Black","company":"Apple","discount":13,"price":70000,"product":"AP1","productdescription":"Some description about AP1","stock":11}]
	
Get the discounted price of all the products by category

	URL: http://localhost:8080/ecartsvc/api/discount-products?category=Mobiles
	Response:
	[{"category":"Mobiles","color":"Black","company":"Apple","discount":13,"price":60900.0000000000000000,"product":"AP1","productdescription":"Some description about AP1","stock":11},{"category":"Mobiles","color":"Grey","company":"Samsung","discount":2,"price":49000.0000000000000000,"product":"SP1","productdescription":"Some description about SP1","stock":2},{"category":"Mobiles","color":"Black","company":"MI","discount":9,"price":18200.0000000000000000,"product":"MP1","productdescription":"Some description about MP1","stock":35}]
	
Place a dummy order in a separate (database) instance. Order placement should fail if the stock = number of dummy orders

	URL: http://localhost:8080/ecartsvc/api/orders
	Request:
	{"orderid":3, "product":"MP1", "quantity":5 }
	

Retrieve all orders

	URL: http://localhost:8080/ecartsvc/api/orders
	Response:
	[{"orderid":3,"product":"MP1","quantity":5}]
	
Delete the dummy order(s)

	URL: http://localhost:8080/ecartsvc/api/orders/3
	
