/* This file was generated by SableCC (http://www.sablecc.org/). */

package calculadora.node;

import calculadora.analysis.*;

@SuppressWarnings("nls")
public final class AMultiId extends PMultiId
{
    private TId _id_;
    private TVir _vir_;

    public AMultiId()
    {
        // Constructor
    }

    public AMultiId(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TVir _vir_)
    {
        // Constructor
        setId(_id_);

        setVir(_vir_);

    }

    @Override
    public Object clone()
    {
        return new AMultiId(
            cloneNode(this._id_),
            cloneNode(this._vir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultiId(this);
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
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
            + toString(this._id_)
            + toString(this._vir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
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
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
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
