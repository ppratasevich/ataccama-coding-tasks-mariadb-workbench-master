*********************************************************************************************

**List all existing databases**
----
  Provides list of all existing databases using the connection object specified.

* **URL**

  listSchemas?id=1

* **Method:**

  `GET`

* **Data Params**

   **Required:**
 
   `id=[integer]` - id of the existing connection object

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	['schema1', 'schema2', schema3]
	```
*********************************************************************************************

**List all existing tables**
----
  Provides list of all existing tables using the connection object specified.

* **URL**

  listTables?id=1

* **Method:**

  `GET`

* **Data Params**

   **Required:**
 
   `id=[integer]` - id of the existing connection object

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	['table1', 'table2', table3]
	```
*********************************************************************************************

**List all table columns**
----
  Provides descriptions of columns in the specified table using the specified connection object.

* **URL**

  listColumns?id=1&table=table1

* **Method:**

  `GET`
  

* **Data Params**

   **Required:**
 
   `id=[integer]` - id of the existing connection object
   `table=[string]` - table name

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	[
		{
			"columnName": "id",
			"columnType": "int(11)",
			"nullable": false,
			"key": "PRI",
			"defaultValue": null,
			"extra": "auto_increment"
		},
		{
			"columnName": "system_id",
			"columnType": "varchar(50)",
			"nullable": true,
			"key": "",
			"defaultValue": null,
			"extra": ""
		},
		{
			"columnName": "ruleset_id",
			"columnType": "varchar(50)",
			"nullable": true,
			"key": "",
			"defaultValue": null,
			"extra": ""
		},
		{
			"columnName": "param_name",
			"columnType": "varchar(50)",
			"nullable": true,
			"key": "MUL",
			"defaultValue": null,
			"extra": ""
		}
	]
	```
*********************************************************************************************
**Preview table data**
----
  Fetches first 50 rows from the specified table using the specified connection object. The fist result row contains column names.

* **URL**

  previewData?id=1&table=table1

* **Method:**

  `GET`
  

* **Data Params**

   **Required:**
 
   `id=[integer]` - id of the existing connection object
   `table=[string]` - table name

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	[
		["id","system_id","ruleset_id","param_name","start_date","end_date","execution_date","model_id"],
		["1","1","WP","TOTALEXECCOUNT","1452476880000","1452649740000","1496947762476",null],
		["4","1","1","TOTALEXECCOUNT","1452476880000","1452649740000","1496958437139",null],
		["6","1","1","TOTALEXECCOUNT","1452476880000","1452649740000","1496958858356",null],
		["24","1","1","TOTALEXECCOUNT","1452463980000","1452636780000","1498760063283",null],
		["25","1","1","TOTALEXECCOUNT","1452452400000","1452463200000","1498769685292",null],
		["26","1","1","TOTALEXECCOUNT","1452452400000","1452463200000","1498770173805",null],
		["27","1","1","TOTALEXECCOUNT","1452456000000","1452466800000","1498770300069",null],
		["31","1","1","TOTALEXECCOUNT","1452452400000","1452456000000","1498930308693",null],
		["32","1","1","TOTALEXECCOUNT","1452452400000","1452456000000","1498939891073",null],
		["47","1","1","MEANRESPTIME","1466312400000","1467266400000","1501190237609",null],
		["48","1","1","MEANRESPTIME","1466222400000","1467172800000","1501191902373",null],
		["49","1","1","MEANRESPTIME","1466222400000","1467172800000","1501192144027",null],
		["50","1","1","MEANRESPTIME","1466222400000","1467172800000","1501192925984",null],
		["51","1","1","MEANRESPTIME","1466222400000","1467172800000","1501205413957",null],
		["52","1","1","MEANRESPTIME","1452477600000","1452740400000","1501526076944",null],
		...
	]
	```
*********************************************************************************************

**Get columns statistics **
----
  Provides statistical data for each column in the specified table using the specified connection object.
  **Note: only applicable to MariaDB versions 10.0.1 or higher. **

* **URL**

  columnsStats?id=1&table=table1

* **Method:**

  `GET`
  

* **Data Params**

   **Required:**
 
   `id=[integer]` - id of the existing connection object
   `table=[string]` - table name

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	[
		{
			"columnName": "id",
			"minValue": "1",
			"maxValue": 8,
			"nullsRatio": "0",
			"avgLength": 1.0,
			"avgFrequency": 1.0
		}
	]
	```

*********************************************************************************************

**Get tables statistics **
----
  Provides statistical data for each table using the specified connection object.

* **URL**

  tablesStats?id=1

* **Method:**

  `GET`
  

* **Data Params**

   **Required:**
 
   `id=[integer]` - id of the existing connection object

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
	```
	[
		{
			"schemaName": "test",
			"tableName": "anomaly_detection_input",
			"rowCount": 30,
			"avgRowLength": 546,
			"dataLength": 16384,
			"createDate": "2018-11-21"
		},
		{
			"schemaName": "test",
			"tableName": "anomaly_detection_output",
			"rowCount": 19622,
			"avgRowLength": 134,
			"dataLength": 2637824,
			"createDate": "2018-11-21"
		},
		{
			"schemaName": "test",
			"tableName": "anomaly_detection_schedule",
			"rowCount": 0,
			"avgRowLength": 0,
			"dataLength": 16384,
			"createDate": "2018-11-21"
		},
		{
			"schemaName": "test",
			"tableName": "anomaly_detection_schedule_input",
			"rowCount": 0,
			"avgRowLength": 0,
			"dataLength": 16384,
			"createDate": "2018-11-21"
		},
	]
	```
*********************************************************************************************