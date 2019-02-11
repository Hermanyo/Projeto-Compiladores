/* This file was generated by SableCC (http://www.sablecc.org/). */

package calculadora.node;

import calculadora.analysis.*;

@SuppressWarnings("nls")
public final class AAddPosAddPos extends PAddPos
{
    private TLCol _lCol_;
    private TNumber _number_;
    private TRCol _rCol_;

    public AAddPosAddPos()
    {
        // Constructor
    }

    public AAddPosAddPos(
        @SuppressWarnings("hiding") TLCol _lCol_,
        @SuppressWarnings("hiding") TNumber _number_,
        @SuppressWarnings("hiding") TRCol _rCol_)
    {
        // Constructor
        setLCol(_lCol_);

        setNumber(_number_);

        setRCol(_rCol_);

    }

    @Override
    public Object clone()
    {
        return new AAddPosAddPos(
            cloneNode(this._lCol_),
            cloneNode(this._number_),
            cloneNode(this._rCol_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAddPosAddPos(this);
    }

    public TLCol getLCol()
    {
        return this._lCol_;
    }

    public void setLCol(TLCol node)
    {
        if(this._lCol_ != null)
        {
            this._lCol_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lCol_ = node;
    }

    public TNumber getNumber()
    {
        return this._number_;
    }

    public void setNumber(TNumber node)
    {
        if(this._number_ != null)
        {
            this._number_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._number_ = node;
    }

    public TRCol getRCol()
    {
        return this._rCol_;
    }

    public void setRCol(TRCol node)
    {
        if(this._rCol_ != null)
        {
            this._rCol_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rCol_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lCol_)
            + toString(this._number_)
            + toString(this._rCol_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lCol_ == child)
        {
            this._lCol_ = null;
            return;
        }

        if(this._number_ == child)
        {
            this._number_ = null;
            return;
        }

        if(this._rCol_ == child)
        {
            this._rCol_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lCol_ == oldChild)
        {
            setLCol((TLCol) newChild);
            return;
        }

        if(this._number_ == oldChild)
        {
            setNumber((TNumber) newChild);
            return;
        }

        if(this._rCol_ == oldChild)
        {
            setRCol((TRCol) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
