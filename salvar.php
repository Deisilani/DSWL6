<?php
include 'conexao.php';

$nome = $_POST['nome'];
$email = $_POST['email'];
$telefone = $_POST['telefone'];

$sql = "INSERT INTO contatos (nome, email, telefone) VALUES ('$nome', '$email', '$telefone')";

$mensagem = "";
if ($conn->query($sql) === TRUE) {
    $mensagem = "Novo contato salvo com sucesso!";
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
    <title>Contato Salvo</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <div class="message-container">
        <div class="message">
            <p><?php echo $mensagem; ?></p>
            <a href="index.php">Voltar</a>
        </div>
    </div>
</body>
</html>
