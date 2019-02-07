/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TFinish extends Token
{
    public TFinish()
    {
        super.setText("finish");
    }

    public TFinish(int line, int pos)
    {
        super.setText("finish");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TFinish(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTFinish(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TFinish text.");
    }
}
