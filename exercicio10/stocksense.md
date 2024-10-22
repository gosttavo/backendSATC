# MODELAGEM REST - STOCKSENSE - Lotes e Produtos

## Casos de uso:
1. Gerenciar informações dos lotes de produtos.
2. Consultar, adicionar e atualizar produtos em estoque.

## Recursos:
- `lotes`
- `produtos`

## Endpoints:

### Lotes

| Descrição                      | URI                            | Método HTTP | Corpo                                                                                             | Resposta Esperada | Erros esperados                    |
|---------------------------------|--------------------------------|-------------|---------------------------------------------------------------------------------------------------|-------------------|-------------------------------------|
| Listar lotes                    | `/lote?empresa={empresa}`       | `GET`       | Vazio                                                                                             | `200 OK`           | `404 Not Found` - lotes não encontrados. |
| Buscar lote por ID              | `/lote/{lote-id}?empresa={empresa}` | `GET`       | Vazio                                                                                             | `200 OK`           | `404 Not Found` - lote não encontrado. |
| Adicionar novo lote             | `/lote?empresa={empresa}`       | `POST`      | `{ "codigoBarras": "123456", "quantidade": 100, "dataFabricacao": "2024-01-10", "dataVencimento": "2024-06-10", "observacoes": "Produto teste", "produto": 1 }` | `201 Created`      | `400 Bad Request` - dados inválidos. |
| Atualizar lote existente        | `/lote/{lote-id}?empresa={empresa}` | `PUT`       | `{ "quantidade": 150 }`                                                                           | `200 OK`           | `404 Not Found` - lote não encontrado. |
| Deletar lote                    | `/lote/{lote-id}?empresa={empresa}` | `DELETE`    | Vazio                                                                                             | `200 OK`           | `404 Not Found` - lote não encontrado. |

### Produtos

| Descrição                      | URI                            | Método HTTP | Corpo                                                                                             | Resposta Esperada | Erros esperados                    |
|---------------------------------|--------------------------------|-------------|---------------------------------------------------------------------------------------------------|-------------------|-------------------------------------|
| Listar produtos                 | `/produto?empresa={empresa}`   | `GET`       | Vazio                                                                                             | `200 OK`           | `404 Not Found` - produtos não encontrados. |
| Buscar produto por ID           | `/produto/{produto-id}?empresa={empresa}` | `GET`       | Vazio                                                                                             | `200 OK`           | `404 Not Found` - produto não encontrado. |
| Adicionar novo produto          | `/produto?empresa={empresa}`   | `POST`      | `{ "descricao": "Produto Teste", "custo": 5.00, "preco": 10.00, "quantidadeMinima": 10, "quantidadeMaxima": 200, "validade": "2024-05-10", "categoria": 1, "empresa": 1 }` | `201 Created`      | `400 Bad Request` - dados inválidos. |
| Atualizar produto existente     | `/produto/{produto-id}?empresa={empresa}` | `PUT`       | `{ "descricao": "Produto Atualizado", "preco": 12.00 }`                                           | `200 OK`           | `404 Not Found` - produto não encontrado. |
| Deletar produto                 | `/produto/{produto-id}?empresa={empresa}` | `DELETE`    | Vazio                                                                                             | `200 OK`           | `404 Not Found` - produto não encontrado. |
