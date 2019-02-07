/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class AVectorTipo extends PTipo
{
    private PTipoBase _tipoBase_;
    private TVector _vector_;
    private final LinkedList<PMultiPos> _multiPos_ = new LinkedList<PMultiPos>();

    public AVectorTipo()
    {
        // Constructor
    }

    public AVectorTipo(
        @SuppressWarnings("hiding") PTipoBase _tipoBase_,
        @SuppressWarnings("hiding") TVector _vector_,
        @SuppressWarnings("hiding") List<?> _multiPos_)
    {
        // Constructor
        setTipoBase(_tipoBase_);

        setVector(_vector_);

        setMultiPos(_multiPos_);

    }

    @Override
    public Object clone()
    {
        return new AVectorTipo(
            cloneNode(this._tipoBase_),
            cloneNode(this._vector_),
            cloneList(this._multiPos_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVectorTipo(this);
    }

    public PTipoBase getTipoBase()
    {
        return this._tipoBase_;
    }

    public void setTipoBase(PTipoBase node)
    {
        if(this._tipoBase_ != null)
        {
            this._tipoBase_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tipoBase_ = node;
    }

    public TVector getVector()
    {
        return this._vector_;
    }

    public void setVector(TVector node)
    {
        if(this._vector_ != null)
        {
            this._vector_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._vector_ = node;
    }

    public LinkedList<PMultiPos> getMultiPos()
    {
        return this._multiPos_;
    }

    public void setMultiPos(List<?> list)
    {
        for(PMultiPos e : this._multiPos_)
        {
            e.parent(null);
        }
        this._multiPos_.clear();

        for(Object obj_e : list)
        {
            PMultiPos e = (PMultiPos) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._multiPos_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tipoBase_)
            + toString(this._vector_)
            + toString(this._multiPos_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tipoBase_ == child)
        {
            this._tipoBase_ = null;
            return;
        }

        if(this._vector_ == child)
        {
            this._vector_ = null;
            return;
        }

        if(this._multiPos_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tipoBase_ == oldChild)
        {
            setTipoBase((PTipoBase) newChild);
            return;
        }

        if(this._vector_ == oldChild)
        {
            setVector((TVector) newChild);
            return;
        }

        for(ListIterator<PMultiPos> i = this._multiPos_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMultiPos) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
