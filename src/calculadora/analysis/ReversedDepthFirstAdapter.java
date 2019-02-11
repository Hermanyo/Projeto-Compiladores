/* This file was generated by SableCC (http://www.sablecc.org/). */

package calculadora.analysis;

import java.util.*;
import calculadora.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
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
        node.getEOF().apply(this);
        node.getPPrograma().apply(this);
        outStart(node);
    }

    public void inACodePrograma(ACodePrograma node)
    {
        defaultIn(node);
    }

    public void outACodePrograma(ACodePrograma node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACodePrograma(ACodePrograma node)
    {
        inACodePrograma(node);
        if(node.getBloco() != null)
        {
            node.getBloco().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getCode() != null)
        {
            node.getCode().apply(this);
        }
        outACodePrograma(node);
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
        if(node.getFinish() != null)
        {
            node.getFinish().apply(this);
        }
        {
            List<PComando> copy = new ArrayList<PComando>(node.getComando());
            Collections.reverse(copy);
            for(PComando e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PDeclaracao> copy = new ArrayList<PDeclaracao>(node.getDeclaracao());
            Collections.reverse(copy);
            for(PDeclaracao e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getStart() != null)
        {
            node.getStart().apply(this);
        }
        outABlocoBloco(node);
    }

    public void inATipoDeclaracao(ATipoDeclaracao node)
    {
        defaultIn(node);
    }

    public void outATipoDeclaracao(ATipoDeclaracao node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATipoDeclaracao(ATipoDeclaracao node)
    {
        inATipoDeclaracao(node);
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            List<PMultiId> copy = new ArrayList<PMultiId>(node.getMultiId());
            Collections.reverse(copy);
            for(PMultiId e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        outATipoDeclaracao(node);
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
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getInicialize() != null)
        {
            node.getInicialize().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getTipo() != null)
        {
            node.getTipo().apply(this);
        }
        if(node.getUnalterable() != null)
        {
            node.getUnalterable().apply(this);
        }
        outAUnaltDeclaracao(node);
    }

    public void inAMultiVar(AMultiVar node)
    {
        defaultIn(node);
    }

    public void outAMultiVar(AMultiVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiVar(AMultiVar node)
    {
        inAMultiVar(node);
        if(node.getVir() != null)
        {
            node.getVir().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAMultiVar(node);
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
        if(node.getVir() != null)
        {
            node.getVir().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAMultiExp(node);
    }

    public void inAMultiId(AMultiId node)
    {
        defaultIn(node);
    }

    public void outAMultiId(AMultiId node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiId(AMultiId node)
    {
        inAMultiId(node);
        if(node.getVir() != null)
        {
            node.getVir().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAMultiId(node);
    }

    public void inAMultiPos(AMultiPos node)
    {
        defaultIn(node);
    }

    public void outAMultiPos(AMultiPos node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiPos(AMultiPos node)
    {
        inAMultiPos(node);
        if(node.getRCol() != null)
        {
            node.getRCol().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLCol() != null)
        {
            node.getLCol().apply(this);
        }
        outAMultiPos(node);
    }

    public void inAInicialize(AInicialize node)
    {
        defaultIn(node);
    }

    public void outAInicialize(AInicialize node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInicialize(AInicialize node)
    {
        inAInicialize(node);
        if(node.getValor() != null)
        {
            node.getValor().apply(this);
        }
        if(node.getRecebeConst() != null)
        {
            node.getRecebeConst().apply(this);
        }
        outAInicialize(node);
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
        {
            List<PMultiPos> copy = new ArrayList<PMultiPos>(node.getMultiPos());
            Collections.reverse(copy);
            for(PMultiPos e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getVector() != null)
        {
            node.getVector().apply(this);
        }
        if(node.getTipoBase() != null)
        {
            node.getTipoBase().apply(this);
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

    public void inAAddPosAddPos(AAddPosAddPos node)
    {
        defaultIn(node);
    }

    public void outAAddPosAddPos(AAddPosAddPos node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAddPosAddPos(AAddPosAddPos node)
    {
        inAAddPosAddPos(node);
        if(node.getRCol() != null)
        {
            node.getRCol().apply(this);
        }
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        if(node.getLCol() != null)
        {
            node.getLCol().apply(this);
        }
        outAAddPosAddPos(node);
    }

    public void inAIdposVar(AIdposVar node)
    {
        defaultIn(node);
    }

    public void outAIdposVar(AIdposVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdposVar(AIdposVar node)
    {
        inAIdposVar(node);
        {
            List<PAddPos> copy = new ArrayList<PAddPos>(node.getAddPos());
            Collections.reverse(copy);
            for(PAddPos e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdposVar(node);
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

    public void inAVarUnalt(AVarUnalt node)
    {
        defaultIn(node);
    }

    public void outAVarUnalt(AVarUnalt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarUnalt(AVarUnalt node)
    {
        inAVarUnalt(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarUnalt(node);
    }

    public void inAValor(AValor node)
    {
        defaultIn(node);
    }

    public void outAValor(AValor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValor(AValor node)
    {
        inAValor(node);
        outAValor(node);
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
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getRecebe() != null)
        {
            node.getRecebe().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
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
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getRecebeConst() != null)
        {
            node.getRecebeConst().apply(this);
        }
        if(node.getUnalt() != null)
        {
            node.getUnalt().apply(this);
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
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        {
            List<PMultiVar> copy = new ArrayList<PMultiVar>(node.getMultiVar());
            Collections.reverse(copy);
            for(PMultiVar e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getCapture() != null)
        {
            node.getCapture().apply(this);
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
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        {
            List<PMultiExp> copy = new ArrayList<PMultiExp>(node.getMultiExp());
            Collections.reverse(copy);
            for(PMultiExp e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getShow() != null)
        {
            node.getShow().apply(this);
        }
        outAShowCmd(node);
    }

    public void inAIfOtherwise(AIfOtherwise node)
    {
        defaultIn(node);
    }

    public void outAIfOtherwise(AIfOtherwise node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfOtherwise(AIfOtherwise node)
    {
        inAIfOtherwise(node);
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getThat() != null)
        {
            node.getThat().apply(this);
        }
        if(node.getCase() != null)
        {
            node.getCase().apply(this);
        }
        if(node.getIn() != null)
        {
            node.getIn().apply(this);
        }
        outAIfOtherwise(node);
    }

    public void inAIfElseNoShortOtherwise(AIfElseNoShortOtherwise node)
    {
        defaultIn(node);
    }

    public void outAIfElseNoShortOtherwise(AIfElseNoShortOtherwise node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfElseNoShortOtherwise(AIfElseNoShortOtherwise node)
    {
        inAIfElseNoShortOtherwise(node);
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        if(node.getBloco() != null)
        {
            node.getBloco().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getThat() != null)
        {
            node.getThat().apply(this);
        }
        if(node.getCase() != null)
        {
            node.getCase().apply(this);
        }
        if(node.getIn() != null)
        {
            node.getIn().apply(this);
        }
        outAIfElseNoShortOtherwise(node);
    }

    public void inACpyComando(ACpyComando node)
    {
        defaultIn(node);
    }

    public void outACpyComando(ACpyComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpyComando(ACpyComando node)
    {
        inACpyComando(node);
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getRecebe() != null)
        {
            node.getRecebe().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outACpyComando(node);
    }

    public void inAConstComando(AConstComando node)
    {
        defaultIn(node);
    }

    public void outAConstComando(AConstComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConstComando(AConstComando node)
    {
        inAConstComando(node);
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getRecebeConst() != null)
        {
            node.getRecebeConst().apply(this);
        }
        if(node.getUnalt() != null)
        {
            node.getUnalt().apply(this);
        }
        outAConstComando(node);
    }

    public void inACaptureComando(ACaptureComando node)
    {
        defaultIn(node);
    }

    public void outACaptureComando(ACaptureComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACaptureComando(ACaptureComando node)
    {
        inACaptureComando(node);
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        {
            List<PMultiVar> copy = new ArrayList<PMultiVar>(node.getMultiVar());
            Collections.reverse(copy);
            for(PMultiVar e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getCapture() != null)
        {
            node.getCapture().apply(this);
        }
        outACaptureComando(node);
    }

    public void inAShowComando(AShowComando node)
    {
        defaultIn(node);
    }

    public void outAShowComando(AShowComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAShowComando(AShowComando node)
    {
        inAShowComando(node);
        if(node.getPpv() != null)
        {
            node.getPpv().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        {
            List<PMultiExp> copy = new ArrayList<PMultiExp>(node.getMultiExp());
            Collections.reverse(copy);
            for(PMultiExp e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getShow() != null)
        {
            node.getShow().apply(this);
        }
        outAShowComando(node);
    }

    public void inAOtherwiseComando(AOtherwiseComando node)
    {
        defaultIn(node);
    }

    public void outAOtherwiseComando(AOtherwiseComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOtherwiseComando(AOtherwiseComando node)
    {
        inAOtherwiseComando(node);
        if(node.getOtherwise() != null)
        {
            node.getOtherwise().apply(this);
        }
        outAOtherwiseComando(node);
    }

    public void inAAsLongAsComando(AAsLongAsComando node)
    {
        defaultIn(node);
    }

    public void outAAsLongAsComando(AAsLongAsComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAsLongAsComando(AAsLongAsComando node)
    {
        inAAsLongAsComando(node);
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        if(node.getAs2() != null)
        {
            node.getAs2().apply(this);
        }
        if(node.getLong() != null)
        {
            node.getLong().apply(this);
        }
        if(node.getAs1() != null)
        {
            node.getAs1().apply(this);
        }
        outAAsLongAsComando(node);
    }

    public void inAConsideringComando(AConsideringComando node)
    {
        defaultIn(node);
    }

    public void outAConsideringComando(AConsideringComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConsideringComando(AConsideringComando node)
    {
        inAConsideringComando(node);
        if(node.getComando() != null)
        {
            node.getComando().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
        }
        if(node.getBy() != null)
        {
            node.getBy().apply(this);
        }
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
        }
        if(node.getTo() != null)
        {
            node.getTo().apply(this);
        }
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
        }
        if(node.getFrom() != null)
        {
            node.getFrom().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getConsidering() != null)
        {
            node.getConsidering().apply(this);
        }
        outAConsideringComando(node);
    }

    public void inABlocoComando(ABlocoComando node)
    {
        defaultIn(node);
    }

    public void outABlocoComando(ABlocoComando node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlocoComando(ABlocoComando node)
    {
        inABlocoComando(node);
        if(node.getBloco() != null)
        {
            node.getBloco().apply(this);
        }
        outABlocoComando(node);
    }

    public void inAFatorExp(AFatorExp node)
    {
        defaultIn(node);
    }

    public void outAFatorExp(AFatorExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFatorExp(AFatorExp node)
    {
        inAFatorExp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        outAFatorExp(node);
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
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outASomaExp(node);
    }

    public void inASubtracaoExp(ASubtracaoExp node)
    {
        defaultIn(node);
    }

    public void outASubtracaoExp(ASubtracaoExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubtracaoExp(ASubtracaoExp node)
    {
        inASubtracaoExp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outASubtracaoExp(node);
    }

    public void inAExpLogicaExp(AExpLogicaExp node)
    {
        defaultIn(node);
    }

    public void outAExpLogicaExp(AExpLogicaExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpLogicaExp(AExpLogicaExp node)
    {
        inAExpLogicaExp(node);
        if(node.getExpLogica() != null)
        {
            node.getExpLogica().apply(this);
        }
        outAExpLogicaExp(node);
    }

    public void inAExpAtribExp(AExpAtribExp node)
    {
        defaultIn(node);
    }

    public void outAExpAtribExp(AExpAtribExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpAtribExp(AExpAtribExp node)
    {
        inAExpAtribExp(node);
        if(node.getExpAtrib() != null)
        {
            node.getExpAtrib().apply(this);
        }
        outAExpAtribExp(node);
    }

    public void inAExpCompExp(AExpCompExp node)
    {
        defaultIn(node);
    }

    public void outAExpCompExp(AExpCompExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpCompExp(AExpCompExp node)
    {
        inAExpCompExp(node);
        if(node.getExpComp() != null)
        {
            node.getExpComp().apply(this);
        }
        outAExpCompExp(node);
    }

    public void inATermoFator(ATermoFator node)
    {
        defaultIn(node);
    }

    public void outATermoFator(ATermoFator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATermoFator(ATermoFator node)
    {
        inATermoFator(node);
        if(node.getTermo() != null)
        {
            node.getTermo().apply(this);
        }
        outATermoFator(node);
    }

    public void inAMultiplicacaoFator(AMultiplicacaoFator node)
    {
        defaultIn(node);
    }

    public void outAMultiplicacaoFator(AMultiplicacaoFator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultiplicacaoFator(AMultiplicacaoFator node)
    {
        inAMultiplicacaoFator(node);
        if(node.getTermo() != null)
        {
            node.getTermo().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        outAMultiplicacaoFator(node);
    }

    public void inADivisaoFator(ADivisaoFator node)
    {
        defaultIn(node);
    }

    public void outADivisaoFator(ADivisaoFator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivisaoFator(ADivisaoFator node)
    {
        inADivisaoFator(node);
        if(node.getTermo() != null)
        {
            node.getTermo().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        outADivisaoFator(node);
    }

    public void inAModuloFator(AModuloFator node)
    {
        defaultIn(node);
    }

    public void outAModuloFator(AModuloFator node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModuloFator(AModuloFator node)
    {
        inAModuloFator(node);
        if(node.getTermo() != null)
        {
            node.getTermo().apply(this);
        }
        if(node.getMod() != null)
        {
            node.getMod().apply(this);
        }
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        outAModuloFator(node);
    }

    public void inAValorTermo(AValorTermo node)
    {
        defaultIn(node);
    }

    public void outAValorTermo(AValorTermo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAValorTermo(AValorTermo node)
    {
        inAValorTermo(node);
        if(node.getValor() != null)
        {
            node.getValor().apply(this);
        }
        outAValorTermo(node);
    }

    public void inAVarTermo(AVarTermo node)
    {
        defaultIn(node);
    }

    public void outAVarTermo(AVarTermo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarTermo(AVarTermo node)
    {
        inAVarTermo(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarTermo(node);
    }

    public void inAParTermo(AParTermo node)
    {
        defaultIn(node);
    }

    public void outAParTermo(AParTermo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParTermo(AParTermo node)
    {
        inAParTermo(node);
        if(node.getRPar() != null)
        {
            node.getRPar().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLPar() != null)
        {
            node.getLPar().apply(this);
        }
        outAParTermo(node);
    }

    public void inANegacaoExpLogica(ANegacaoExpLogica node)
    {
        defaultIn(node);
    }

    public void outANegacaoExpLogica(ANegacaoExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegacaoExpLogica(ANegacaoExpLogica node)
    {
        inANegacaoExpLogica(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getNot() != null)
        {
            node.getNot().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outANegacaoExpLogica(node);
    }

    public void inAOuExpLogica(AOuExpLogica node)
    {
        defaultIn(node);
    }

    public void outAOuExpLogica(AOuExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExpLogica(AOuExpLogica node)
    {
        inAOuExpLogica(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getOr() != null)
        {
            node.getOr().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAOuExpLogica(node);
    }

    public void inAXouExpLogica(AXouExpLogica node)
    {
        defaultIn(node);
    }

    public void outAXouExpLogica(AXouExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAXouExpLogica(AXouExpLogica node)
    {
        inAXouExpLogica(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getXor() != null)
        {
            node.getXor().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAXouExpLogica(node);
    }

    public void inAEExpLogica(AEExpLogica node)
    {
        defaultIn(node);
    }

    public void outAEExpLogica(AEExpLogica node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEExpLogica(AEExpLogica node)
    {
        inAEExpLogica(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getAnd() != null)
        {
            node.getAnd().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAEExpLogica(node);
    }

    public void inARecExpAtrib(ARecExpAtrib node)
    {
        defaultIn(node);
    }

    public void outARecExpAtrib(ARecExpAtrib node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARecExpAtrib(ARecExpAtrib node)
    {
        inARecExpAtrib(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getRecebe() != null)
        {
            node.getRecebe().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outARecExpAtrib(node);
    }

    public void inARecConstExpAtrib(ARecConstExpAtrib node)
    {
        defaultIn(node);
    }

    public void outARecConstExpAtrib(ARecConstExpAtrib node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARecConstExpAtrib(ARecConstExpAtrib node)
    {
        inARecConstExpAtrib(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getRecebeConst() != null)
        {
            node.getRecebeConst().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outARecConstExpAtrib(node);
    }

    public void inAMaiorExpComp(AMaiorExpComp node)
    {
        defaultIn(node);
    }

    public void outAMaiorExpComp(AMaiorExpComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorExpComp(AMaiorExpComp node)
    {
        inAMaiorExpComp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getGreater() != null)
        {
            node.getGreater().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAMaiorExpComp(node);
    }

    public void inAMenorExpComp(AMenorExpComp node)
    {
        defaultIn(node);
    }

    public void outAMenorExpComp(AMenorExpComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorExpComp(AMenorExpComp node)
    {
        inAMenorExpComp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getLesser() != null)
        {
            node.getLesser().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAMenorExpComp(node);
    }

    public void inAIgualExpComp(AIgualExpComp node)
    {
        defaultIn(node);
    }

    public void outAIgualExpComp(AIgualExpComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIgualExpComp(AIgualExpComp node)
    {
        inAIgualExpComp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getTwoequal() != null)
        {
            node.getTwoequal().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAIgualExpComp(node);
    }

    public void inAMaiorigualExpComp(AMaiorigualExpComp node)
    {
        defaultIn(node);
    }

    public void outAMaiorigualExpComp(AMaiorigualExpComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMaiorigualExpComp(AMaiorigualExpComp node)
    {
        inAMaiorigualExpComp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getGoe() != null)
        {
            node.getGoe().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAMaiorigualExpComp(node);
    }

    public void inAMenorigualExpComp(AMenorigualExpComp node)
    {
        defaultIn(node);
    }

    public void outAMenorigualExpComp(AMenorigualExpComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMenorigualExpComp(AMenorigualExpComp node)
    {
        inAMenorigualExpComp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getLoe() != null)
        {
            node.getLoe().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAMenorigualExpComp(node);
    }

    public void inADiferenteExpComp(ADiferenteExpComp node)
    {
        defaultIn(node);
    }

    public void outADiferenteExpComp(ADiferenteExpComp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADiferenteExpComp(ADiferenteExpComp node)
    {
        inADiferenteExpComp(node);
        if(node.getFator() != null)
        {
            node.getFator().apply(this);
        }
        if(node.getDiff() != null)
        {
            node.getDiff().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outADiferenteExpComp(node);
    }
}
