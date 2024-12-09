<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Cadastro de Contatos</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h2>Cadastro de Contatos</h2>
    <form action="salvar.php" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <label for="telefone">Telefone:</label>
        <input type="tel" id="telefone" name="telefone" required>
        
        <button type="submit">Salvar</button>
    </form>
    <br>
    <div style="text-align: center;">
        <a href="listar.php">Listar Contatos</a>
    </div>
</body>
</html>
