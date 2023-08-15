package list.OperacoesBasicas.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String name, double price, int quantity){
        itemList.add(new Item(name, price, quantity));
    }

    public void removerItem(String name){
        List<Item> itemsParaRemover = new ArrayList<>();
        for (Item it: itemList) {
            if (it.getName().equalsIgnoreCase(name)) {
                itemsParaRemover.add(it);
            }
        }
        itemList.removeAll(itemsParaRemover);
    }

    public double calcularValorTotal(){
        double sum = 0;
        for (Item its: itemList) {
           sum += its.getPrice()*its.getQuantity();
        }
        return sum;
    }

    public void exibirItens(){
        for (Item its: itemList) {
            System.out.println(its);
        }

    }

    public static void main(String[] args) {

        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("leite",5.4,2);
        carrinhoDeCompras.adicionarItem("Pão",0.25,10);
        carrinhoDeCompras.adicionarItem("Pão",0.25,10);

        System.out.println("Valor do carrinho: "+carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("leite");

        System.out.println("-------------------------------");
        System.out.println("Valor do carrinho: "+carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();
    }
}
