<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>
	<h1>Bem vindo ao nosso gerenciador de empresas!</h1>
	<br />

	<c:if test="${not empty usuarioLogado}">
    Você está logado como ${usuarioLogado.email}<br />
	</c:if>
	</ br>
	<form action="executa?tarefa=NovaEmpresa" method="post">
		Nome: <input type="text" name="nome" /><br /> 
		<input type="submit"
			value="Enviar" />
	</form>

	<form action="login" method="post">
		Email: <input type="text" name="email" /><br /> Senha: <input
			type="password" name="senha" /><br /> <input type="submit"
			value="Login" />
	</form>

	<form action="executa?tarefa=Logout" method="post">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>