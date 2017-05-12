# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Esta API REST foi feita para atender ao teste solicitado pela accesstage e visa auxiliar movimentações 
* interbancarias registrando as movimentações empossibilitando consultas    

### How do I get set up? ###

* Projeto desenvolvido em Java 1.8 e utiliza o Framework Spring 4, commons-lang3 e com.h2database
* O banco de dado é criado em memória a cada vez que o serviço é iniciado utilizando o H2 DataBase
* Para rodar os testes é necessário fazer requisições nas URLs abaixo através de um cliente por exemplo o POSTMAN.

1 - Para realizar movimentação com apenas uma movimentação

Realizar POST em: http://localhost:8080/api/movimentacao/{remetente}/{destinatario}/unique

Enviando JSON conforme o exemplo abaixo:
{
	"linha":"TED0114004851Antonio Alves da Silva        54561747150003256924032017"
}

A API retornará:

{
  "linhaEntrada": "TED0114004851Antonio Alves da Silva        54561747150003256924032017",
  "linhaSaida": "54561747150Antonio Alves da Silva        01140048510032569TED24032017"
}
 

2 - Para realizar movimentação com varias movimentações

Realize POST em: http://localhost:8080/api/movimentacao/{remetente}/{destinatario}/many

Enviando JSON conforme o exemplo abaixo:
[
	{
		"linha":"TED0114004851Antonio da Silva              54561747150003256924032017"
	},{
		"linha":"TED0114004851Antonio Alves                 54561747150003256924032017"
	},{
		"linha":"TED0114004851Maria Alves da Silva          54561747150003256924032017"
	},{
		"linha":"TED0114004851Jose Alves da Silva           54561747150003256924032017"
	}
]

A API retornará:

[
  {
    "linhaEntrada": "TED0114004851Antonio da Silva              54561747150003256924032017",
    "linhaSaida": "54561747150Antonio da Silva              01140048510032569TED24032017"
  },
  {
    "linhaEntrada": "TED0114004851Antonio Alves                 54561747150003256924032017",
    "linhaSaida": "54561747150Antonio Alves                 01140048510032569TED24032017"
  },
  {
    "linhaEntrada": "TED0114004851Maria Alves da Silva          54561747150003256924032017",
    "linhaSaida": "54561747150Maria Alves da Silva          01140048510032569TED24032017"
  },
  {
    "linhaEntrada": "TED0114004851Jose Alves da Silva           54561747150003256924032017",
    "linhaSaida": "54561747150Jose Alves da Silva           01140048510032569TED24032017"
  }
]

3 - Consultas de movimentações

3.1 - Consultar Movimentações Por Remetente
	3.1.1 - Para buscar movimentações enviadas -> Envie GET: http://localhost:8080/api/movimentacao/{remetente}/entrada
	API RETORNA:
	[
	  {
	    "id": 1,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Antonio Alves da Silva        ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "destinatario"
	  },
	  {
	    "id": 2,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Antonio da Silva              ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  },
	  {
	    "id": 3,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Antonio Alves                 ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  },
	  {
	    "id": 4,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Maria Alves da Silva          ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  },
	  {
	    "id": 5,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Jose Alves da Silva           ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  }
	]
	3.1.2 - Para buscar as saidas das movimentações -> Envie GET: http://localhost:8080/api/movimentacao/{remetente}/saida
	[
	  {
	    "cpf": "54561747150",
	    "favorecido": "Antonio Alves da Silva        ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Antonio Alves da Silva        01140048510032569TED24032017",
	    "conta": "004851"
	  },
	  {
	    "cpf": "54561747150",
	    "favorecido": "Antonio da Silva              ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Antonio da Silva              01140048510032569TED24032017",
	    "conta": "004851"
	  },
	  {
	    "cpf": "54561747150",
	    "favorecido": "Antonio Alves                 ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Antonio Alves                 01140048510032569TED24032017",
	    "conta": "004851"
	  },
	  {
	    "cpf": "54561747150",
	    "favorecido": "Maria Alves da Silva          ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Maria Alves da Silva          01140048510032569TED24032017",
	    "conta": "004851"
	  },
	  {
	    "cpf": "54561747150",
	    "favorecido": "Jose Alves da Silva           ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Jose Alves da Silva           01140048510032569TED24032017",
	    "conta": "004851"
	  }
	]
	3.2 - Consultar Movimentações Por Remetente e Destinatario
	3.2.1 - Para buscar movimentações enviadas -> Envie GET: http://localhost:8080/api/movimentacao/{remetente}/{destinatario}/entrada
	API RETORNA:
	[
	  {
	    "id": 2,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Antonio da Silva              ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  },
	  {
	    "id": 3,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Antonio Alves                 ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  },
	  {
	    "id": 4,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Maria Alves da Silva          ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  },
	  {
	    "id": 5,
	    "tipoTransacao": "TED",
	    "agencia": "0114",
	    "conta": "00485",
	    "digitoConta": "1",
	    "favorecido": "Jose Alves da Silva           ",
	    "cpf": "54561747150",
	    "valorTransacaoSemDecimais": "00325",
	    "valorTransacaoDecimais": "69",
	    "dataTransacao": "24032017",
	    "instituicaoRemetente": "rem",
	    "instituicaoDestinataria": "dest"
	  }
	]
	3.2.2 - Para buscar as saidas das movimentações -> Envie GET: http://localhost:8080/api/movimentacao/{remetente}/{destinatario}/saida
	API RETORNA:
	[
	  {
	    "cpf": "54561747150",
	    "favorecido": "Antonio da Silva              ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Antonio da Silva              01140048510032569TED24032017",
	    "conta": "004851"
	  },
	  {
	    "cpf": "54561747150",
	    "favorecido": "Antonio Alves                 ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Antonio Alves                 01140048510032569TED24032017",
	    "conta": "004851"
	  },
	  {
	    "cpf": "54561747150",
	    "favorecido": "Maria Alves da Silva          ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Maria Alves da Silva          01140048510032569TED24032017",
	    "conta": "004851"
	  },
	  {
	    "cpf": "54561747150",
	    "favorecido": "Jose Alves da Silva           ",
	    "agencia": "0114",
	    "contaComDigito": "004851",
	    "valorComDecimal": "0032569",
	    "tipoTransacao": "TED",
	    "dataTransacao": "24032017",
	    "linha": "54561747150Jose Alves da Silva           01140048510032569TED24032017",
	    "conta": "004851"
	  }
	]
	


### Contribution guidelines ###

* 

### Who do I talk to? ###
