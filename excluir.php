<?php
include 'conexao.php';

$id = $_GET['id'];

$sql = "DELETE FROM contatos WHERE id=$id";

$mensagem = "";
if ($conn->query($sql) === TRUE) {
    $mensagem = "Contato excluído com sucesso!";
} else {
    $mensagem = "Erro: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contato Excluído</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <div class="message-container">
        <div class="message">
            <p><?php echo $mensagem; ?></p>
            <a href="listar.php">Voltar</a>
        </div>
    </div>
</body>
</html>
