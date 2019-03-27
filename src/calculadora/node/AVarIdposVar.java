/* This file was generated by SableCC (http://www.sablecc.org/). */

package calculadora.node;

import java.util.*;
import calculadora.analysis.*;

@SuppressWarnings("nls")
public final class AVarIdposVar extends PVar
{
    private TId _id_;
    private final LinkedList<PExp> _addPos_ = new LinkedList<PExp>();

    public AVarIdposVar()
    {
        // Constructor
    }

    public AVarIdposVar(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") List<?> _addPos_)
    {
        // Constructor
        setId(_id_);

        setAddPos(_addPos_);

    }

    @Override
    public Object clone()
    {
        return new AVarIdposVar(
            cloneNode(this._id_),
            cloneList(this._addPos_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarIdposVar(this);
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

    public LinkedList<PExp> getAddPos()
    {
        return this._addPos_;
    }

    public void setAddPos(List<?> list)
    {
        for(PExp e : this._addPos_)
        {
            e.parent(null);
        }
        this._addPos_.clear();

        for(Object obj_e : list)
        {
            PExp e = (PExp) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._addPos_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._addPos_);
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

        if(this._addPos_.remove(child))
        {
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

        for(ListIterator<PExp> i = this._addPos_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PExp) newChild);
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
