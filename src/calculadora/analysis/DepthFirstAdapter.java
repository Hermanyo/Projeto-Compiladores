/* This file was generated by SableCC (http://www.sablecc.org/). */

package calculadora.analysis;

import java.util.*;
import calculadora.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPPrograma().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAProgramaPrograma(AProgramaPrograma node)
    {
        defaultIn(node);
    }

    public void outAProgramaPrograma(AProgramaPrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProgramaPrograma(AProgramaPrograma node)
    {
        inAProgramaPrograma(node);
        if(node.getName() != null)
        {
            node.getName().apply(this);
        }
        if(node.getBloco() != null)
        {
            node.getBloco().apply(this);
        }
        outAProgramaPrograma(node);
    }

    public void inABlocoBloco(ABlocoBloco node)
    {
        defaultIn(node);
    }

    public void outABlocoBloco(ABlocoBloco node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlocoBloco(ABlocoBloco node)
    {
        inABlocoBloco(node);
        {
            List<PDeclaracao> copy = new ArrayList<PDeclaracao>(node.getDeclaracao());
            for(PDeclaracao e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PComando> copy = new ArrayList<PComando>(node.getComando());
            for(PComando e : copy)
            {
                e.apply(this);
            }
        }
        outABlocoBloco(node);
    }

    public void inADeclaracaoDeclaracao(ADeclaracaoDeclaracao node)
    {
        defaultIn(node);
    }

    public void outADeclaracaoDeclaracao(ADeclaracaoDeclaracao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADeclaracaoDeclaracao(ADeclaracaoDeclaracao node)
    {
        inADeclaracaoDeclaracao(node);
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        {
            List<TId> copy = new ArrayList<TId>(node.getIdList());
            for(TId e : copy)
            {
                e.apply(this);
            }
        }
        outADeclaracaoDeclaracao(node);
    }

    public void inAUnaltDeclaracao(AUnaltDeclaracao node)
    {
        defaultIn(node);
    }

    public void outAUnaltDeclaracao(AUnaltDeclaracao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAUnaltDeclaracao(AUnaltDeclaracao node)
    {
        inAUnaltDeclaracao(node);
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getInicialize() != null)
        {
            node.getInicialize().apply(this);
        }
        outAUnaltDeclaracao(node);
    }

    public void inAIntegerTipoBase(AIntegerTipoBase node)
    {
        defaultIn(node);
    }

    public void outAIntegerTipoBase(AIntegerTipoBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntegerTipoBase(AIntegerTipoBase node)
    {
        inAIntegerTipoBase(node);
        if(node.getInteger() != null)
        {
            node.getInteger().apply(this);
        }
        outAIntegerTipoBase(node);
    }

    public void inARealTipoBase(ARealTipoBase node)
    {
        defaultIn(node);
    }

    public void outARealTipoBase(ARealTipoBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARealTipoBase(ARealTipoBase node)
    {
        inARealTipoBase(node);
        if(node.getReal() != null)
        {
            node.getReal().apply(this);
        }
        outARealTipoBase(node);
    }

    public void inASymbolTipoBase(ASymbolTipoBase node)
    {
        defaultIn(node);
    }

    public void outASymbolTipoBase(ASymbolTipoBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASymbolTipoBase(ASymbolTipoBase node)
    {
        inASymbolTipoBase(node);
        if(node.getSymbol() != null)
        {
            node.getSymbol().apply(this);
        }
        outASymbolTipoBase(node);
    }

    public void inAVectorTipo(AVectorTipo node)
    {
        defaultIn(node);
    }

    public void outAVectorTipo(AVectorTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVectorTipo(AVectorTipo node)
    {
        inAVectorTipo(node);
        if(node.getTipoBase() != null)
        {
            node.getTipoBase().apply(this);
        }
        {
            List<PExp> copy = new ArrayList<PExp>(node.getMultiPos());
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        outAVectorTipo(node);
    }

    public void inATipoBaseTipo(ATipoBaseTipo node)
    {
        defaultIn(node);
    }

    public void outATipoBaseTipo(ATipoBaseTipo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoBaseTipo(ATipoBaseTipo node)
    {
        inATipoBaseTipo(node);
        if(node.getTipoBase() != null)
        {
            node.getTipoBase().apply(this);
        }
        outATipoBaseTipo(node);
    }

    public void inAVarIdposVar(AVarIdposVar node)
    {
        defaultIn(node);
    }

    public void outAVarIdposVar(AVarIdposVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarIdposVar(AVarIdposVar node)
    {
        inAVarIdposVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<TNumber> copy = new ArrayList<TNumber>(node.getAddPos());
            for(TNumber e : copy)
            {
                e.apply(this);
            }
        }
        outAVarIdposVar(node);
    }

    public void inAIdVar(AIdVar node)
    {
        defaultIn(node);
    }

    public void outAIdVar(AIdVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdVar(AIdVar node)
    {
        inAIdVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdVar(node);
    }

    public void inAUnaltIdposUnalt(AUnaltIdposUnalt node)
    {
        defaultIn(node);
    }

    public void outAUnaltIdposUnalt(AUnaltIdposUnalt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAUnaltIdposUnalt(AUnaltIdposUnalt node)
    {
        inAUnaltIdposUnalt(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<TNumber> copy = new ArrayList<TNumber>(node.getAddPos());
            for(TNumber e : copy)
            {
                e.apply(this);
            }
        }
        outAUnaltIdposUnalt(node);
    }

    public void inAIdUnalt(AIdUnalt node)
    {
        defaultIn(node);
    }

    public void outAIdUnalt(AIdUnalt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdUnalt(AIdUnalt node)
    {
        inAIdUnalt(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdUnalt(node);
    }

    public void inACaractereValor(ACaractereValor node)
    {
        defaultIn(node);
    }

    public void outACaractereValor(ACaractereValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACaractereValor(ACaractereValor node)
    {
        inACaractereValor(node);
        if(node.getChar() != null)
        {
            node.getChar().apply(this);
        }
        outACaractereValor(node);
    }

    public void inANumeroValor(ANumeroValor node)
    {
        defaultIn(node);
    }

    public void outANumeroValor(ANumeroValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumeroValor(ANumeroValor node)
    {
        inANumeroValor(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumeroValor(node);
    }

    public void inARealValor(ARealValor node)
    {
        defaultIn(node);
    }

    public void outARealValor(ARealValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARealValor(ARealValor node)
    {
        inARealValor(node);
        if(node.getFloat() != null)
        {
            node.getFloat().apply(this);
        }
        outARealValor(node);
    }

    public void inAPalavraValor(APalavraValor node)
    {
        defaultIn(node);
    }

    public void outAPalavraValor(APalavraValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPalavraValor(APalavraValor node)
    {
        inAPalavraValor(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAPalavraValor(node);
    }

    public void inACpyCmd(ACpyCmd node)
    {
        defaultIn(node);
    }

    public void outACpyCmd(ACpyCmd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpyCmd(ACpyCmd node)
    {
        inACpyCmd(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outACpyCmd(node);
    }

    public void inAConstCmd(AConstCmd node)
    {
        defaultIn(node);
    }

    public void outAConstCmd(AConstCmd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConstCmd(AConstCmd node)
    {
        inAConstCmd(node);
        if(node.getUnalt() != null)
        {
            node.getUnalt().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAConstCmd(node);
    }

    public void inACaptureCmd(ACaptureCmd node)
    {
        defaultIn(node);
    }

    public void outACaptureCmd(ACaptureCmd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACaptureCmd(ACaptureCmd node)
    {
        inACaptureCmd(node);
        {
            List<PVar> copy = new ArrayList<PVar>(node.getMultiVar());
            for(PVar e : copy)
            {
                e.apply(this);
            }
        }
        outACaptureCmd(node);
    }

    public void inAShowCmd(AShowCmd node)
    {
        defaultIn(node);
    }

    public void outAShowCmd(AShowCmd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAShowCmd(AShowCmd node)
    {
        inAShowCmd(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getMultiExp());
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        outAShowCmd(node);
    }

    public void inAAsLongAsCmd(AAsLongAsCmd node)
    {
        defaultIn(node);
    }

    public void outAAsLongAsCmd(AAsLongAsCmd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAsLongAsCmd(AAsLongAsCmd node)
    {
        inAAsLongAsCmd(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getCmd() != null)
        {
            node.getCmd().apply(this);
        }
        outAAsLongAsCmd(node);
    }

    public void inAConsideringCmd(AConsideringCmd node)
    {
        defaultIn(node);
    }

    public void outAConsideringCmd(AConsideringCmd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConsideringCmd(AConsideringCmd node)
    {
        inAConsideringCmd(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getExp1() != null)
        {
            node.getExp1().apply(this);
        }
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        if(node.getCmd() != null)
        {
            node.getCmd().apply(this);
        }
        outAConsideringCmd(node);
    }

    public void inABlocoCmd(ABlocoCmd node)
    {
        defaultIn(node);
    }

    public void outABlocoCmd(ABlocoCmd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlocoCmd(ABlocoCmd node)
    {
        inABlocoCmd(node);
        if(node.getBloco() != null)
        {
            node.getBloco().apply(this);
        }
        outABlocoCmd(node);
    }

    public void inAElseOtherwise(AElseOtherwise node)
    {
        defaultIn(node);
    }

    public void outAElseOtherwise(AElseOtherwise node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseOtherwise(AElseOtherwise node)
    {
        inAElseOtherwise(node);
        if(node.getCmd() != null)
        {
            node.getCmd().apply(this);
        }
        outAElseOtherwise(node);
    }

    public void inACmdComando(ACmdComando node)
    {
        defaultIn(node);
    }

    public void outACmdComando(ACmdComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACmdComando(ACmdComando node)
    {
        inACmdComando(node);
        if(node.getCmd() != null)
        {
            node.getCmd().apply(this);
        }
        outACmdComando(node);
    }

    public void inAIfComando(AIfComando node)
    {
        defaultIn(node);
    }

    public void outAIfComando(AIfComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfComando(AIfComando node)
    {
        inAIfComando(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getCmd() != null)
        {
            node.getCmd().apply(this);
        }
        if(node.getOtherwise() != null)
        {
            node.getOtherwise().apply(this);
        }
        outAIfComando(node);
    }

    public void inAValorExp(AValorExp node)
    {
        defaultIn(node);
    }

    public void outAValorExp(AValorExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValorExp(AValorExp node)
    {
        inAValorExp(node);
        if(node.getValor() != null)
        {
            node.getValor().apply(this);
        }
        outAValorExp(node);
    }

    public void inAVarExp(AVarExp node)
    {
        defaultIn(node);
    }

    public void outAVarExp(AVarExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarExp(AVarExp node)
    {
        inAVarExp(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarExp(node);
    }

    public void inANegativoExp(ANegativoExp node)
    {
        defaultIn(node);
    }

    public void outANegativoExp(ANegativoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegativoExp(ANegativoExp node)
    {
        inANegativoExp(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outANegativoExp(node);
    }

    public void inAParExp(AParExp node)
    {
        defaultIn(node);
    }

    public void outAParExp(AParExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParExp(AParExp node)
    {
        inAParExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAParExp(node);
    }

    public void inAMultiExp(AMultiExp node)
    {
        defaultIn(node);
    }

    public void outAMultiExp(AMultiExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiExp(AMultiExp node)
    {
        inAMultiExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMultiExp(node);
    }

    public void inADivExp(ADivExp node)
    {
        defaultIn(node);
    }

    public void outADivExp(ADivExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivExp(ADivExp node)
    {
        inADivExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outADivExp(node);
    }

    public void inAModuloExp(AModuloExp node)
    {
        defaultIn(node);
    }

    public void outAModuloExp(AModuloExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModuloExp(AModuloExp node)
    {
        inAModuloExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAModuloExp(node);
    }

    public void inASomaExp(ASomaExp node)
    {
        defaultIn(node);
    }

    public void outASomaExp(ASomaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASomaExp(ASomaExp node)
    {
        inASomaExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outASomaExp(node);
    }

    public void inASubtrExp(ASubtrExp node)
    {
        defaultIn(node);
    }

    public void outASubtrExp(ASubtrExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubtrExp(ASubtrExp node)
    {
        inASubtrExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outASubtrExp(node);
    }

    public void inANegacaoExp(ANegacaoExp node)
    {
        defaultIn(node);
    }

    public void outANegacaoExp(ANegacaoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegacaoExp(ANegacaoExp node)
    {
        inANegacaoExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outANegacaoExp(node);
    }

    public void inAOuExp(AOuExp node)
    {
        defaultIn(node);
    }

    public void outAOuExp(AOuExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        inAOuExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAOuExp(node);
    }

    public void inAXouExp(AXouExp node)
    {
        defaultIn(node);
    }

    public void outAXouExp(AXouExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAXouExp(AXouExp node)
    {
        inAXouExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAXouExp(node);
    }

    public void inAEExp(AEExp node)
    {
        defaultIn(node);
    }

    public void outAEExp(AEExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEExp(AEExp node)
    {
        inAEExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAEExp(node);
    }

    public void inARecExp(ARecExp node)
    {
        defaultIn(node);
    }

    public void outARecExp(ARecExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARecExp(ARecExp node)
    {
        inARecExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outARecExp(node);
    }

    public void inARecConstExp(ARecConstExp node)
    {
        defaultIn(node);
    }

    public void outARecConstExp(ARecConstExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARecConstExp(ARecConstExp node)
    {
        inARecConstExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outARecConstExp(node);
    }

    public void inAMaiorExp(AMaiorExp node)
    {
        defaultIn(node);
    }

    public void outAMaiorExp(AMaiorExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorExp(AMaiorExp node)
    {
        inAMaiorExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMaiorExp(node);
    }

    public void inAMenorExp(AMenorExp node)
    {
        defaultIn(node);
    }

    public void outAMenorExp(AMenorExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorExp(AMenorExp node)
    {
        inAMenorExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMenorExp(node);
    }

    public void inAIgualExp(AIgualExp node)
    {
        defaultIn(node);
    }

    public void outAIgualExp(AIgualExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIgualExp(AIgualExp node)
    {
        inAIgualExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAIgualExp(node);
    }

    public void inAMaiorOuIgualExp(AMaiorOuIgualExp node)
    {
        defaultIn(node);
    }

    public void outAMaiorOuIgualExp(AMaiorOuIgualExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorOuIgualExp(AMaiorOuIgualExp node)
    {
        inAMaiorOuIgualExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMaiorOuIgualExp(node);
    }

    public void inAMenorOuIgualExp(AMenorOuIgualExp node)
    {
        defaultIn(node);
    }

    public void outAMenorOuIgualExp(AMenorOuIgualExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorOuIgualExp(AMenorOuIgualExp node)
    {
        inAMenorOuIgualExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMenorOuIgualExp(node);
    }

    public void inADiffExp(ADiffExp node)
    {
        defaultIn(node);
    }

    public void outADiffExp(ADiffExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADiffExp(ADiffExp node)
    {
        inADiffExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outADiffExp(node);
    }
}
