<?php
include 'conexao.php';

$id = $_GET['id'];

$sql = "SELECT * FROM contatos WHERE id=$id";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
} else {
    echo "Contato não encontrado.";
    exit;
}

$conn->close();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Contato</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h2>Editar Contato</h2>
    <form action="atualizar.php" method="post">
        <input type="hidden" name="id" value="<?php echo $row['id']; ?>">
        
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<?php echo $row['nome']; ?>" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<?php echo $row['email']; ?>" required>
        
        <label for="telefone">Telefone:</label>
        <input type="tel" id="telefone" name="telefone" value="<?php echo $row['telefone']; ?>" required>
        
        <button type="submit">Atualizar</button>
    </form>
    <br>
    <div style="text-align: center;">
        <a href="listar.php">Voltar</a>
    </div>
</body>
</html>
