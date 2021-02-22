*********************************************************************************************

**Create new connection**
----
  Saves DB connection object into the Database.

* **URL**

  connection/new

* **Method:**

  `POST`
  
*  **Request body object**
```
  {
	"name": "Test1",
	"hostname": "localhost",
	"port": 3306,
	"databaseName": "dbName",
	"username": "user",
	"password": "password",
	"id": 1
   }
 ```

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `1` - identifier of the connection object in the Database
	
*********************************************************************************************

**View existing connections**
----
  Returns list of connection objects currently saved in the Database.

* **URL**

  connection/list

* **Method:**

  `GET`
  
*  **URL Params**

	None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	[
		{
			"name": "Test1",
			"hostname": "localhost",
			"port": 3306,
			"databaseName": "dbName",
			"username": "user",
			"password": "password",
			"id": 1
		},
		{
			"name": "Test2",
			"hostname": "localhost",
			"port": 3306,
			"databaseName": "anotherDBName",
			"username": "user",
			"password": "password",
			"id": 2
		}
	]
	```

*********************************************************************************************

**View single connection details**
----
  Returns single connection object by specified id.

* **URL**

  /connection/show/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	{
		"name": "Test1",
		"hostname": "localhost",
		"port": 3306,
		"databaseName": "dbName",
		"username": "user",
		"password": "password",
		"id": 1
	}
	```
	
*********************************************************************************************

**Delete connection object**
----
  Removes specified connection object from the Database

* **URL**

  /connection/delete/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** List of the remaining connection objects
	```
	[
		{
			"name": "Test2",
			"hostname": "localhost",
			"port": 3306,
			"databaseName": "anotherDBName",
			"username": "user",
			"password": "password",
			"id": 2
		}
	]
	```