/* This file was generated by SableCC (http://www.sablecc.org/). */

package analysis;

import java.util.*;
import node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACodePrograma(ACodePrograma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoBloco(ABlocoBloco node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInicialize(AInicialize node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATipoDeclaracao(ATipoDeclaracao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAUnaltDeclaracao(AUnaltDeclaracao node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiVar(AMultiVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiExp(AMultiExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiId(AMultiId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiPos(AMultiPos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntegerTipoBase(AIntegerTipoBase node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealTipoBase(ARealTipoBase node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASymbolTipoBase(ASymbolTipoBase node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATipoBaseTipo(ATipoBaseTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVectorTipo(AVectorTipo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddPosAddPos(AAddPosAddPos node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdVar(AIdVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdposVar(AIdposVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarUnalt(AVarUnalt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValor(AValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACaractereValor(ACaractereValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumeroValor(ANumeroValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARealValor(ARealValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPalavraValor(APalavraValor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACpyComando(ACpyComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConstComando(AConstComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACaptureComando(ACaptureComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAShowComando(AShowComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInCaseThatComando(AInCaseThatComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAsLongAsComando(AAsLongAsComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConsideringComando(AConsideringComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocoComando(ABlocoComando node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFatorExp(AFatorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASomaExp(ASomaExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASubtracaoExp(ASubtracaoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARecExp(ARecExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARecConstExp(ARecConstExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMaiorExp(AMaiorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorExp(AMenorExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegacaoExp(ANegacaoExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEExp(AEExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIgualExp(AIgualExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMaiorigualExp(AMaiorigualExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMenorigualExp(AMenorigualExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADiferenteExp(ADiferenteExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATermoFator(ATermoFator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultiplicacaoFator(AMultiplicacaoFator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivisaoFator(ADivisaoFator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAModuloFator(AModuloFator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValorTermo(AValorTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarTermo(AVarTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParTermo(AParTermo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReal(TReal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInteger(TInteger node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSymbol(TSymbol node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVector(TVector node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCode(TCode node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStart(TStart node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFinish(TFinish node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTUnalterable(TUnalterable node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIn(TIn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCase(TCase node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTThat(TThat node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDo(TDo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAs(TAs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLong(TLong node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTConsidering(TConsidering node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFrom(TFrom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTo(TTo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBy(TBy node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCapture(TCapture node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTShow(TShow node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMod(TMod node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRecebe(TRecebe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRecebeConst(TRecebeConst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGreater(TGreater node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLesser(TLesser node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTXor(TXor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTwoequal(TTwoequal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGoe(TGoe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLoe(TLoe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiff(TDiff node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLCom(TLCom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRCom(TRCom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLCol(TLCol node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRCol(TRCol node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPpv(TPpv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVir(TVir node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTChar(TChar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNumber(TNumber node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFloat(TFloat node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComment(TComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
