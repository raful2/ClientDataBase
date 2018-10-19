 <?php 
//echo htmlspecialchars_decode(($_POST['nome'])); 
//echo htmlspecialchars_decode($_POST['saldo']); 

$nome = $_POST['nome'];
$saldo = $_POST['saldo'];
$web = 1;


/*function getData(){
$datatimezone = new DateTimeZone('Brazil/Northwest');
$data = new DateTime();
$data->setTime($datatimezone);
	return $data->format('Y,m,d H,i,s');
}
*/
$now = date_create('now')->format('Y-m-d H:i:s');
$db = 'nexti';
$conexao = mysqli_connect("localhost", "root", "");
mysqli_select_db($conexao, $db);
$sql_inclu = "INSERT INTO cliente2(nome, saldo, d_data, web) VALUES ('$nome', '$saldo', '$now','$web')";
$exe_inclu = mysqli_query($conexao,$sql_inclu) or die (mysqli_error($conexao));




if (!$conexao) {
    echo "Erro ao conectar com a base de dados." . PHP_EOL;
    exit;
}
//Se der certo continua
echo "SUCESSO" . PHP_EOL;
echo "Host information: " . mysqli_get_host_info($conexao) . PHP_EOL;


//Disconnect
mysqli_close($conexao);
?>
