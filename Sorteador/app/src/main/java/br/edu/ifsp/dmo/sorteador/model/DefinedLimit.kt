package br.edu.ifsp.dmo.sorteador.model
/*
 * Classe DefinedLimit define qual a borda superior que será
 * considerada no sorteio. Observa-se que a classe mantém
 * como borda inferior o valor 1, assim os sorteios são
 * realizados sempre no intervalo [1..border]
 */
class DefinedLimit(private val border: Int) : SorteioStrategy() {
    override fun nextNumber(): Int {
        return random.nextInt(1, border + 1)
    }
    override fun getLowBorder(): Int {
        return 1
    }
    override fun getHighBorder(): Int {
        return border
    }
}