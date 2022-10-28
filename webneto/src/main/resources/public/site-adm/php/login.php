<?php
session_start();

try {
    $conn = mysqli_connect('localhost','postgres','ti@cc','webneto', '5432');    
}catch(\Exception $error){
    var_dump($error);
}

$usuario = $_POST['usuario'];
$senha = $_POST['senha'];

$logar = mysqli_query($conn, "SELECT * FROM adm where usuario = '$usuario' and senha = '$senha'; ");

if ($logar->num_rows !== 0) {
    $row = mysqli_fetch_array($logar);

    $_SESSION['usuario'] = $usuario;
    $_SESSION['senha'] = $senha;
    header('Location: ../html/cadastros.html');

} else {
    header('Location: ../html/index.html');
    null;
}

?>