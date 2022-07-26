package defaults;

public class Clase04_HerenciaMultiple_issues_client implements Clase03_Interface1, Clase04_HerenciaMultiple_issues{
    //Al implementar mas de una interface con una firma de método igual, nos va a tirar un error de compilacion
    //Cuando ocurre esto, no nos queda otra que implementar la funcionalidad de este método en cuestión

    @Override
    public void methodA() {
        System.out.println("HOLA DESDE METHODA DESDE LA IMPLEMENTACION POR EL ISSUE");
    }

    public static void main(String[] args) {
        Clase04_HerenciaMultiple_issues_client client = new Clase04_HerenciaMultiple_issues_client();
        client.methodA();
    }


}
