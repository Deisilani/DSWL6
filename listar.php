<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Contatos</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <h2>Lista de Contatos</h2>
    <table>
        <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Ações</th>
        </tr>
        <?php
        include 'conexao.php';

        $sql = "SELECT * FROM contatos";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                echo "<tr>";
                echo "<td>" . $row['nome'] . "</td>";
                echo "<td>" . $row['email'] . "</td>";
                echo "<td>" . $row['telefone'] . "</td>";
                echo "<td><a href='editar.php?id=" . $row['id'] . "'>Editar</a> | <a href='excluir.php?id=" . $row['id'] . "'>Excluir</a></td>";
                echo "</tr>";
            }
        } else {
            echo "<tr><td colspan='4'>Nenhum contato encontrado</td></tr>";
        }

        $conn->close();
        ?>
    </table>
    <br>
    <div style="text-align: center;">
        <a href="index.php">Voltar</a>
    </div>
</body>
</html>
