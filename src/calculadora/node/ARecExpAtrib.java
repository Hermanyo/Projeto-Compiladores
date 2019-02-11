/* This file was generated by SableCC (http://www.sablecc.org/). */

package calculadora.node;

import calculadora.analysis.*;

@SuppressWarnings("nls")
public final class ARecExpAtrib extends PExpAtrib
{
    private PExp _exp_;
    private TRecebe _recebe_;
    private PFator _fator_;

    public ARecExpAtrib()
    {
        // Constructor
    }

    public ARecExpAtrib(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TRecebe _recebe_,
        @SuppressWarnings("hiding") PFator _fator_)
    {
        // Constructor
        setExp(_exp_);

        setRecebe(_recebe_);

        setFator(_fator_);

    }

    @Override
    public Object clone()
    {
        return new ARecExpAtrib(
            cloneNode(this._exp_),
            cloneNode(this._recebe_),
            cloneNode(this._fator_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARecExpAtrib(this);
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

    public TRecebe getRecebe()
    {
        return this._recebe_;
    }

    public void setRecebe(TRecebe node)
    {
        if(this._recebe_ != null)
        {
            this._recebe_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._recebe_ = node;
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
            + toString(this._recebe_)
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

        if(this._recebe_ == child)
        {
            this._recebe_ = null;
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

        if(this._recebe_ == oldChild)
        {
            setRecebe((TRecebe) newChild);
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
