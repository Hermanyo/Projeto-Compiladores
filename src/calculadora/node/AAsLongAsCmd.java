/* This file was generated by SableCC (http://www.sablecc.org/). */

package calculadora.node;

import calculadora.analysis.*;

@SuppressWarnings("nls")
public final class AAsLongAsCmd extends PCmd
{
    private TAs _as1_;
    private TLong _long_;
    private TAs _as2_;
    private TLPar _lPar_;
    private PExp _exp_;
    private TRPar _rPar_;
    private TDo _do_;
    private PComando _comando_;

    public AAsLongAsCmd()
    {
        // Constructor
    }

    public AAsLongAsCmd(
        @SuppressWarnings("hiding") TAs _as1_,
        @SuppressWarnings("hiding") TLong _long_,
        @SuppressWarnings("hiding") TAs _as2_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") TDo _do_,
        @SuppressWarnings("hiding") PComando _comando_)
    {
        // Constructor
        setAs1(_as1_);

        setLong(_long_);

        setAs2(_as2_);

        setLPar(_lPar_);

        setExp(_exp_);

        setRPar(_rPar_);

        setDo(_do_);

        setComando(_comando_);

    }

    @Override
    public Object clone()
    {
        return new AAsLongAsCmd(
            cloneNode(this._as1_),
            cloneNode(this._long_),
            cloneNode(this._as2_),
            cloneNode(this._lPar_),
            cloneNode(this._exp_),
            cloneNode(this._rPar_),
            cloneNode(this._do_),
            cloneNode(this._comando_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAsLongAsCmd(this);
    }

    public TAs getAs1()
    {
        return this._as1_;
    }

    public void setAs1(TAs node)
    {
        if(this._as1_ != null)
        {
            this._as1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._as1_ = node;
    }

    public TLong getLong()
    {
        return this._long_;
    }

    public void setLong(TLong node)
    {
        if(this._long_ != null)
        {
            this._long_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._long_ = node;
    }

    public TAs getAs2()
    {
        return this._as2_;
    }

    public void setAs2(TAs node)
    {
        if(this._as2_ != null)
        {
            this._as2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._as2_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
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

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    public TDo getDo()
    {
        return this._do_;
    }

    public void setDo(TDo node)
    {
        if(this._do_ != null)
        {
            this._do_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._do_ = node;
    }

    public PComando getComando()
    {
        return this._comando_;
    }

    public void setComando(PComando node)
    {
        if(this._comando_ != null)
        {
            this._comando_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comando_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._as1_)
            + toString(this._long_)
            + toString(this._as2_)
            + toString(this._lPar_)
            + toString(this._exp_)
            + toString(this._rPar_)
            + toString(this._do_)
            + toString(this._comando_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._as1_ == child)
        {
            this._as1_ = null;
            return;
        }

        if(this._long_ == child)
        {
            this._long_ = null;
            return;
        }

        if(this._as2_ == child)
        {
            this._as2_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        if(this._do_ == child)
        {
            this._do_ = null;
            return;
        }

        if(this._comando_ == child)
        {
            this._comando_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._as1_ == oldChild)
        {
            setAs1((TAs) newChild);
            return;
        }

        if(this._long_ == oldChild)
        {
            setLong((TLong) newChild);
            return;
        }

        if(this._as2_ == oldChild)
        {
            setAs2((TAs) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        if(this._do_ == oldChild)
        {
            setDo((TDo) newChild);
            return;
        }

        if(this._comando_ == oldChild)
        {
            setComando((PComando) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
