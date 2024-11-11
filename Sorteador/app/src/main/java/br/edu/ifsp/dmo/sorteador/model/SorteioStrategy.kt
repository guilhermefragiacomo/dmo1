package br.edu.ifsp.dmo.sorteador.model
import kotlin.random.Random
/*
 * Para o desenvolvimento deste aplicativo está sendo considerado
 * o Design Pattern Strategy. Sugere-se o estudo do padrão no
 * site: <https://refactoring.guru/design-patterns/strategy>.
 *
 * De forma geral, a aplicação irá alterar sua estratégia, ou seja,
 * seu comportamento lógico, durante a execução da aplicação.
 *
 * A classe SorteioStrategy é uma classe modelo para o desenvolvimento
 * de outras estratégias. Então as subclasses de SorteioStrategy são
 * estratégias válidas para a aplicação.
 */
abstract class SorteioStrategy() {
    protected val random = Random.Default
    abstract fun nextNumber(): Int
    abstract fun getLowBorder(): Int
    abstract fun getHighBorder(): Int
}
