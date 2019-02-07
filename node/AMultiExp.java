/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AMultiExp extends PMultiExp
{
    private PExp _exp_;
    private TVir _vir_;

    public AMultiExp()
    {
        // Constructor
    }

    public AMultiExp(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TVir _vir_)
    {
        // Constructor
        setExp(_exp_);

        setVir(_vir_);

    }

    @Override
    public Object clone()
    {
        return new AMultiExp(
            cloneNode(this._exp_),
            cloneNode(this._vir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultiExp(this);
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

    public TVir getVir()
    {
        return this._vir_;
    }

    public void setVir(TVir node)
    {
        if(this._vir_ != null)
        {
            this._vir_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._vir_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._vir_);
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

        if(this._vir_ == child)
        {
            this._vir_ = null;
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

        if(this._vir_ == oldChild)
        {
            setVir((TVir) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
