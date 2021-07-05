#Documentación
API creada para el mantenimiento de una base de datos en memoria sobre super héroes.

-----------------------------

###Mostrar todos los super héroes `GET`

```/superhero```

|Tipo de parámetros|Valor|Ejemplo|
|-----------------|-----|-------|
|-|-|-|

|Tipo de respuesta| Código| Cuerpo|
-------------|-------------|----------
|Respuesta satisfactoria|200|```[{"id":1,"name":"Ironman"},{"id":2,"name":"Spider-man"},{"id":3,"name":"Lobezno"}, {"id":4,"name":"Manolito"}, {"id":5,"name":"Super López"}]```|

###Mostrar todos los super héroes `POST`
```/superhero```

|Tipo de parámetros|Valor|Ejemplo|
|-----------------|-----|-------|
|Request Body|name|```{"name" : "Ironman"}```|

|Tipo de respuesta| Código| Cuerpo|
-------------|-------------|----------
|Respuesta satisfactoria|200|```{ "id": 6, "name": "Ironman"}```|
|No hay parámetros| 400 | ```{"timestamp":"2021-07-05T16:52:08.640+00:00","status":400,"error":"Bad Request","path":"/superhero"}```|

###Buscar por nombre `GET`
```/superhero/search```

|Tipo de parámetros|Valor|Ejemplo|
|-----------------|-----|-------|
|Query Params|name|```superhero/search?name="man"```|

|Tipo de respuesta| Código| Cuerpo|
-------------|-------------|----------
|Respuesta satisfactoria|200|```[{"id":1,"name":"Superman"},{"id":2,"name":"Spider-man"}, {"id":4,"name":"Manolito"}, { "id": 6, "name": "Ironman"}]```|

###Buscar por id `GET`
```/superhero/{id}```

|Tipo de parámetros|Valor|Ejemplo|
|-----------------|-----|-------|
|Path Variable|id|```superhero/2```|

|Tipo de respuesta| Código| Cuerpo|
-------------|-------------|----------
|Respuesta satisfactoria|200|```{"id":2,"name":"Spider-man"}```|
|El ID no existe|204| ```{"timestamp":"2021-07-05T16:57:09.772+00:00","message":"Superhero not found for this id: 7","details":"uri=/superhero/7"}```|

###Modificar un super héroe `PUT`
```/superhero/{id}```

|Tipo de parámetros|Valor|Ejemplo|
|-----------------|-----|-------|
|Path Variable|id|```superhero/2```|
|Body Request|name|```{"name" : "Ironman"}```|

|Tipo de respuesta| Código| Cuerpo|
-------------|-------------|----------
|Respuesta satisfactoria|200|```{"id":2,"name":"Ironman"}```|
|El ID no existe|204| ```{"timestamp":"2021-07-05T17:05:14.227+00:00","message":"Superhero not found for this id: 8","details":"uri=/superhero/8"}```|

###Eliminar un super héroe `DELETE`
```/superhero/{id}```

|Tipo de parámetros|Valor|Ejemplo|
|-----------------|-----|-------|
|Path Variable|id|```superhero/2```|

|Tipo de respuesta| Código| Cuerpo|
-------------|-------------|----------
|Respuesta satisfactoria|200|``` ```|
|El ID no existe|500| ```{"timestamp":"2021-07-05T17:07:31.327+00:00","status":500,"error":"Internal Server Error","path":"/superhero/9"}```|











