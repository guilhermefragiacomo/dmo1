package br.edu.ifsp.dmo.sorteador.model
/*
 * Uma das possíveis estratégias é o uso de um valor
 * padrão para os sorteios, no caso, o padrão é
 * um intervalo de [1..1000].
 *
 * DefaultLimit é um Singleton, ou seja, só existe
 * uma instância dessa classe na memória. Em Kotlin
 * o Singleton é criado com a definição de um _object_
 * e não uma classe.
 *
 * Para conhecer melhor o Design Pattern Singleton
 * recomenda-se a leitura do site:
 * <https://refactoring.guru/design-patterns/singleton>
 */
object DefaultLimit : SorteioStrategy() {
    private val BORDER_DEFAULT = 1000
    override fun nextNumber(): Int {
        return random.nextInt(1, BORDER_DEFAULT + 1)
    }
    override fun getLowBorder(): Int {
        return 1
    }
    override fun getHighBorder(): Int {
        return BORDER_DEFAULT
    }
}
