# Problem Description

Scientists need a digital solution to store and identify various items used in their experiments.
These items come in different forms and might include samples, chemicals, devices, etc...
A usual practice in laboratories is to store the items in categories. Each category has attribute
definitions and each item in those categories should fit into those definitions. You can imagine
categories as database tables while attribute definitions are columns. Items are, in this case, the
rows in those database tables.
The Task
Please create a REST API application using Java which provides the following functionality:
● Creating categories with attribute definitions
● Creating items in those categories
● Updating items
● Getting items of a category

## Design ideas for given project:

Category: liquid detergent					
					
Attributes name:	Ml	expiry	price	fragrance	
Attribute Type:  	Number	Date	Number	text	
surf excel 	400	2022	100rs	jasmine	Item 1
tide	500	2023	120rs	rose	Item2

Category: cloth					
Attributes name:	material	length	price	which_country	colour
Attribute Type:  	Text	Number	Number	text	
surf excel 	jeans  danim	2m	600rs	maxico	Item 1
tide	shirt_cotton	1m	1000rs	india	Item2


Observation and design approach: 

Approach 1:
•	if we go this way every time we define new table structure., so that is not manageable .
•	for it to work as REST end point API we need to have predefined attributes for items. 
•	we can think of this as very general item attributes. But even then its up to users how do they want to name those attributes.
•	i can think of supported item attributes types and let user choose the name. so this way, we can have one categories table which will keep track of all categories we have, every time we update category this table will be updated.
•	we can have items table which will store value of all attributes types expose, item table have many to one mapping of categoryId of category table. This way one category can have many items associated with it. 
•	we will have one more table item_attributs_category_label_mapping which will store all attribute and label mapping of given item 
•	so this way , everytime we will have item query for given category , we will read all item attributes for given category from items table. we will read item_attributs_category_label_mapping for given category and create mapper object and map those values into category related items. [this i think is little expensive if categories and items tables are huge and changing frequently ] 


- Categories table [categoryId, Name, Description,Attribute]
- Attribute table it’s not separate table , it will be embedded into Categories table  [number ,short_desc ,long_desc ,url]
-  number --> can be used to label as Qty, weight, dimension , price , serial number
-  short_desc --> can be used to store info about item short desc
-  long_desc --> can be used to store info about item ,more information 
-  url  --> can be pointing at item image , item purchase link 
-  items table with below attribute 
-  [itemId,categoryId, number ,long_Description,short_Description url ]

## Features 
- we can create Categories with given attributes

## API End points
api/v1/categories  method POST
api/v1/categories method Get

## POST Request Sample
{
	"name": "Liquid Category",
	"description": "to help better track Liduid stuff in lab",
	"attribute": {
		"number": "qty",
		"long_desc": "solutions items in lab",
		"short_desc": "short desc",
		"url" : "https://www.amazon.in/Surf-Excel-Easy-Detergent-Powder/dp/B00TS8ABHC"
		}
}

##  POST Response Sample
{
    "categoryId": 2,
    "name": "Liquid Category",
    "description": "to help better track Liduid stuff in lab",
    "attribute": {
        "number": "qty",
        "short_desc": "short desc",
        "long_desc": "solutions items in lab",
        "url": "https://www.amazon.in/Surf-Excel-Easy-Detergent-Powder/dp/B00TS8ABHC"
    }
}

## GET resoponse 
[
    {
        "categoryId": 1,
        "name": "Solid Category",
        "description": "to help better track solid stuff in lab",
        "attribute": {
            "number": "qty",
            "short_desc": "short desc",
            "long_desc": "this is long solid desc",
            "url": null
        }
    },
    {
        "categoryId": 2,
        "name": "Liquid Category",
        "description": "to help better track Liduid stuff in lab",
        "attribute": {
            "number": "qty",
            "short_desc": "short desc",
            "long_desc": "solutions items in lab",
            "url": "https://www.amazon.in/Surf-Excel-Easy-Detergent-Powder/dp/B00TS8ABHC"
        }
    }
]

## work in progress 
- for adding item and upating categories work is still not completed

## ToBe Completed Features 
- there can be a few more attributes we can think of , like Date ,
- Date --> can be expiery date, mfg date, purchase date,
- i will tackle this if i get more time after completing given task 


## how to test this 
 please run CurdApplication.java file as java application 
 
 
 ## Database information 
to test this application i am using h2 db, at this point i have not added code to populate DB. DB will be populated once category is created successfully. 

 
## License
MIT

