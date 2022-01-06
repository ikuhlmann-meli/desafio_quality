## Mercado Livre Brasil

## Bootcamp - Meli Wave 4 - Digital House

### Desafio Quality

#### Grupo 11

- [Stéphanie da Silva Leal](https://github.com/stephleal)
- [Lucas Garcia Macchione Prudente Correa](https://github.com/LucasGarcia97)
- [Mauro Bergonzoni Junqueira](https://github.com/mbjunqueiraweb)
- [Iberê Abondanza Kuhlmann](https://github.com/ikuhlmann-meli)
- [Matheus Santos Alencar](https://github.com/matheussalencar)

#### Documentação para consultar a API


GET ``` area/{nomeDaCasa} ``` <br/>

GET ``` valor/{nomeDaCasa} ``` <br/>

GET ``` areaComodos/{nomeDaCasa} ``` <br/>

GET ``` maiorComodo/{nomeDaCasa} ``` <br/>

POST ``` imovel```

Exemplo de body:

```
   {
    "name": "Novacasa",
    "district": {
        "name": "Bairro do Limoeiro",
        "squaredMeterValue": 200
    },
    "rooms": [
        {
            "name": "Quarto",
            "width": 10,
            "length": 20
        }
      ]
    }
```

