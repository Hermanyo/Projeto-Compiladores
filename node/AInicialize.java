/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AInicialize extends PInicialize
{
    private TRecebeConst _recebeConst_;
    private PValor _valor_;

    public AInicialize()
    {
        // Constructor
    }

    public AInicialize(
        @SuppressWarnings("hiding") TRecebeConst _recebeConst_,
        @SuppressWarnings("hiding") PValor _valor_)
    {
        // Constructor
        setRecebeConst(_recebeConst_);

        setValor(_valor_);

    }

    @Override
    public Object clone()
    {
        return new AInicialize(
            cloneNode(this._recebeConst_),
            cloneNode(this._valor_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInicialize(this);
    }

    public TRecebeConst getRecebeConst()
    {
        return this._recebeConst_;
    }

    public void setRecebeConst(TRecebeConst node)
    {
        if(this._recebeConst_ != null)
        {
            this._recebeConst_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._recebeConst_ = node;
    }

    public PValor getValor()
    {
        return this._valor_;
    }

    public void setValor(PValor node)
    {
        if(this._valor_ != null)
        {
            this._valor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._valor_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._recebeConst_)
            + toString(this._valor_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._recebeConst_ == child)
        {
            this._recebeConst_ = null;
            return;
        }

        if(this._valor_ == child)
        {
            this._valor_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._recebeConst_ == oldChild)
        {
            setRecebeConst((TRecebeConst) newChild);
            return;
        }

        if(this._valor_ == oldChild)
        {
            setValor((PValor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
