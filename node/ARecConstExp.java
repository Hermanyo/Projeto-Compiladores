/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ARecConstExp extends PExp
{
    private PExp _exp_;
    private TRecebeConst _recebeConst_;
    private PFator _fator_;

    public ARecConstExp()
    {
        // Constructor
    }

    public ARecConstExp(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TRecebeConst _recebeConst_,
        @SuppressWarnings("hiding") PFator _fator_)
    {
        // Constructor
        setExp(_exp_);

        setRecebeConst(_recebeConst_);

        setFator(_fator_);

    }

    @Override
    public Object clone()
    {
        return new ARecConstExp(
            cloneNode(this._exp_),
            cloneNode(this._recebeConst_),
            cloneNode(this._fator_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARecConstExp(this);
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
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

    public PFator getFator()
    {
        return this._fator_;
    }

    public void setFator(PFator node)
    {
        if(this._fator_ != null)
        {
            this._fator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fator_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._recebeConst_)
            + toString(this._fator_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._recebeConst_ == child)
        {
            this._recebeConst_ = null;
            return;
        }

        if(this._fator_ == child)
        {
            this._fator_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._recebeConst_ == oldChild)
        {
            setRecebeConst((TRecebeConst) newChild);
            return;
        }

        if(this._fator_ == oldChild)
        {
            setFator((PFator) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
