<?php
include 'conexao.php';

$id = $_POST['id'];
$nome = $_POST['nome'];
$email = $_POST['email'];
$telefone = $_POST['telefone'];

$sql = "UPDATE contatos SET nome='$nome', email='$email', telefone='$telefone' WHERE id=$id";

$mensagem = "";
if ($conn->query($sql) === TRUE) {
    $mensagem = "Contato atualizado com sucesso!";
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
    <title>Contato Atualizado</title>
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
