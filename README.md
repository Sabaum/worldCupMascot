worldCupMascot
==============
##Informações
O sistema foi testado em Linux e Windows.

Foi utilizado o Java 7 e o banco MySQL no desenvolvimento do projeto.
O script está no diretório do projeto num arquivo de nome mascote.sql.

É preciso que a variável de ambiente $JAVA_HOME esteja apontando para uma instalação de Java 7.

Os parâmetros necessários para subir a aplicação ficam em um arquivo separado, de nome 'config.properties'.

Há também uma tabela de parâmetros de configuração,
onde deve ser configurada a data na qual a votação se tornará pública.
No banco também tem uma tabela de usuários, onde foram criados 2 usuários, cada um com sua regra. São eles:

1 - ADMIN - senha: 12345678 (senha criptografada em md5 no banco)

2 - USUARIO - senha: 123456 (senha criptografada em md5 no banco)


##Execução
Para executar a aplicação, và até o diretório raíz da aplicação e digite "mvn clean install jetty:run"

Assim que o servidor for iniciado, o usuário deve digitar no browser a seguinte url: 'localhost:8080/mascot/vote'.

Irá abrir a página de votação, onde acontecem os votos.

Foi feito um pequeno conjunto de links para navegação nas páginas criadas para facilitar a navegação na aplicação.
Ele fica no canto superior direito da tela.

O link 'Votação' leva para a tela de votação, onde são efetuados os votos.

O link 'Resultado' leva para a tela de resultado,
que só será mostrada se a data corrente for maior que a data configurada no parâmetro do banco.

O link 'Admin' também leva para a página de resultado,
porém para acessar esse link é preciso estar autenticado como administrador.
Se não estiver, o usuário será direcionado para a tela de login, onde poderá fazer o login como administrador,
e ao fazê-lo, será direcionado novamente para a tela de votação acessada somente pelo admin.

Caso seja do seu interesse deslogar e logar com um usuário difernte,
a aplicação disponibiliza o link 'Logout' para desvincular o usuário da sessão,
podendo assim efetuar login com outro usuário.
