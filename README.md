# API-SYSTEM-CAR

Application responsible for making car service requests

## Features

- Register user in the system
- Generate a token for access to the endpoints
- Register user car in the system
- Check user car data
- Request automatic services for the car

## API documentation

#### Register user in the system

```http
  POST /api/user/register
```

| Parameter   | Type       | Description                       |
| :---------- |:-----------|:----------------------------------|
| `Content-Type` | `string`   | **Mandatory**. A chave da sua API |

#### Generate a token for access to the endpoints

```http
  POST /api/auth/login
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- |:---------------------------------|
| `email`      | `string` | **Mandatory**. User's email    |
| `password`      | `string` | **Mandatory**. User's password |

#### Register user car in the system

```http
  POST /api/car
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- |:---------------------------------|
| `email`      | `string` | **Mandatory**. User's email    |
| `password`      | `string` | **Mandatory**. User's password |


## Link Collection Postman

- [Link Collection Postman](https://web.postman.co/workspace/52b937b6-7177-4965-8442-73df9837e43d/collection/11489151-5aae158c-3f55-47c1-9fcb-2d12b6062b6e?action=share&source=copy-link&creator=11489151)


## Authors

- [Yuri Moysés da Silva](https://www.linkedin.com/in/yuri-moys%C3%A9s-541451176/)

