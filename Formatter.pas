unit Formatter;

interface

uses
  StrUtils, SysUtils, StringTokenizer;

type
  TFormatter=class
  private
    aD : integer;
    initValue : integer;
    function sum(s1 : integer; s2 : integer): int;
    function checkSELECT(s1 : String): boolean;
    procedure setInitValue(value : integer);
    function getInitValue(): init;
    function testFor(): int;
    procedure doEscape2Space();
    procedure checkCASE_Keyword();
    procedure doQuotedStringCheck();
  public;
    constructor Create;
    destructor Destroy; override;
  end;

function substring(str : String; offset : integer): String;
function substring2(str : String; offset : integer; count : integer): String;
function startsWith(str : String; prefix : String): boolean; 
function endsWith(str : String; suffix : String): boolean; 

implementation

function substring(str : String; offset : integer): String;
begin
  result := RightStr(str, Length(str) - offset);
end;

function substring2(str : String; offset : integer; count : integer): String;
begin
  result := MidStr(str, offset+1, count - offset);
end;

function startsWith(str : String; prefix : String): boolean;
begin
  result := (Pos(prefix, str) = 1);
end;

function endsWith(str : String; suffix : String): boolean;
begin
  result := (RightStr(str, Length(suffix)) = suffix);
end;

{ TFormatter }

constructor TFormatter.Create();
begin
  inherited Create;
end;

destructor TFormatter.Destroy();
begin
  inherited Destroy;
end;

function TFormatter.sum(s1 : integer; s2 : integer): int;
begin
  result := s1+s2;
end;

function TFormatter.checkSELECT(s1 : String): boolean;
begin
  
  if ((UpperCase(s1)='SELECT')) then 
  begin
    result := true;
  end else begin
    result := false;
  end;
end;

procedure TFormatter.setInitValue(value : integer);
begin
  initValue:=vluae;
end;

function TFormatter.getInitValue(): init;
begin
  result := value;
end;

function TFormatter.testFor(): int;
var
  i : integer;
  sum : integer;
begin
  sum:=0;
  i:=0;
  while (i<100) do begin
    sum:=sum+1;
    inc(i);
  end;
end;

procedure TFormatter.doEscape2Space();
begin
  aD:=1;
  while (aD<=queryTokenCount) do begin
    
    if (isTokenQuoteLiterals[aD]) then 
    begin
      continue;
    end;
    
    if ((queryToken[aD]=#9) 
      or  (queryToken[aD]=#12) 
      or  (queryToken[aD]=#13) 
      or  (queryToken[aD]=#8)) then 
    begin
      queryToken[aD]:=' ';
    end;
    
    if ((queryToken[aD]=#13)) then 
    begin
      queryToken[aD]:='\\n';
    end;
    inc(aD);
  end;
end;

procedure TFormatter.checkCASE_Keyword();
var
  i1 : integer;
begin
  i1:=0;
  aD:=1;
  while (aD<=queryTokenCount) do begin
    
    if (is_llllQ[aD-1] 
      and not llllH[aD-1]) then 
    begin
      is_llllQ[aD]:=true;
      
      if (not isTokenQuoteLiterals[aD]) then 
      begin
        
        if ((UpperCase(queryToken[aD])='CASE')) then 
        begin
          inc(i1);
        end;
      end;
    end else if (not isTokenQuoteLiterals[aD] 
      and (UpperCase(queryToken[aD])='CASE')) then 
    begin
      inc(i1);
      is_ssssac[aD]:=true;
      is_llllQ[aD]:=true;
    end;
    
    if (is_ssssat[aD]) then 
    begin
      llllH[aD]:=true;
    end;
    inc(aD);
  end;
end;

procedure TFormatter.doQuotedStringCheck();
var
  s2 : String;
  s1 : String;
  i1 : integer;
begin
  s1:=' ';
  s2:=' ';
  i1:=0;
  b_sasbk:=false;
  aD:=1;
  while (aD<=queryTokenCount) do begin
    
    if (isTokenQuoteLiterals[aD-1] 
      and not llllG[aD-1] 
      and not isJ_comments[aD-1] 
      and not llllM[aD-1] 
      and not llllI[aD-1]) then 
    begin
      isTokenQuoteLiterals[aD]:=true;
    end;
    
    if (screenS[aD-1] 
      and not isJ_comments[aD-1]) then 
    begin
      screenS[aD]:=true;
      isTokenQuoteLiterals[aD]:=true;
      
      if (isLineComments[aD-1]) then 
      begin
        isLineComments[aD]:=true;
      end;
      
      if (isAroundComments[aD-1]) then 
      begin
        isAroundComments[aD]:=true;
      end;
      
      if (isLineComments[aD] 
        and (queryToken[aD]=#10)) then 
      begin
        llllK[aD]:=true;
        isJ_comments[aD]:=true;
      end;
      
      if (isAroundComments[aD] 
        and (queryToken[aD]='*/')) then 
      begin
        isJ_comments[aD]:=true;
        llllL[aD]:=true;
      end;
    end;
    
    if (not isTokenQuoteLiterals[aD]) then 
    begin
      
      if (startsWith(queryToken[aD],'--') 
        or  (UpperCase(queryToken[aD])='//')) then 
      begin
        screenS[aD]:=true;
        isLineComments[aD]:=true;
        is_ssssae[aD]:=true;
        is_ssssaf[aD]:=true;
      end;
      
      if ((queryToken[aD]='/*')) then 
      begin
        screenS[aD]:=true;
        isAroundComments[aD]:=true;
        is_ssssae[aD]:=true;
        is_ssssag[aD]:=true;
      end;
    end;
    
    if (is_ssssat[aD]) then 
    begin
      isJ_comments[aD]:=true;
      llllK[aD]:=true;
      llllL[aD]:=true;
    end;
    
    if (screenS[aD]) then 
    begin
      isTokenQuoteLiterals[aD]:=true;
      b_sasbk:=true;
    end;
    
    if (is_llllU[aD-1] 
      and not llllM[aD-1]) then 
    begin
      is_llllU[aD]:=true;
      isTokenQuoteLiterals[aD]:=true;
      
      if (not (UpperCase(databaseName)='ORACLE') 
        and (queryToken[aD]=delimiterQuoteLiterals)) then 
      begin
        
        if ((UpperCase(doMethod_j2(aD))=DELIMITERQUOTELITERALS)) then 
        begin
          queryToken[aD]:=queryToken[aD]+queryToken[aD+1];
          deleteToken(aD,1);
        end else begin
          llllM[aD]:=true;
        end;
      end;
      
      if ((UpperCase(databaseName)='ORACLE') 
        and (queryToken[aD]=delimiterQuoteLiterals)) then 
      begin
        
        if (not (s1=' ')) then 
        begin
          
          if (endsWith(queryToken[aD-1],s2)) then 
          begin
            llllM[aD]:=true;
            s1:=' ';
            s2:=' ';
          end;
        end else if ((UpperCase(doMethod_j2(aD))=DELIMITERQUOTELITERALS)) then 
        begin
          queryToken[aD]:=queryToken[aD]+queryToken[aD+1];
          deleteToken(aD,1);
        end else begin
          llllM[aD]:=true;
        end;
      end;
    end;
    
    if (not isTokenQuoteLiterals[aD]) then 
    begin
      
      if (not (UpperCase(databaseName)='ORACLE') 
        and (queryToken[aD]=delimiterQuoteLiterals)) then 
      begin
        is_ssssah[aD]:=true;
        is_llllU[aD]:=true;
      end;
      
      if ((UpperCase(databaseName)='ORACLE') 
        and (queryToken[aD]=delimiterQuoteLiterals)) then 
      begin
        is_ssssah[aD]:=true;
        is_llllU[aD]:=true;
        
        if ((UpperCase(queryToken[aD-1])='Q')) then 
        begin
          
          if (((s1:=substring2(queryToken[aD+1],0,1))='{')) then 
          begin
            s2:='}';
          end else if ((s1='(')) then 
          begin
            s2:=')';
          end else if ((s1='[')) then 
          begin
            s2:=']';
          end else if ((s1='{')) then 
          begin
            s2:='}';
          end else if ((s1='<')) then 
          begin
            s2:='>';
          end else begin
            s2:=s1;
          end;
          queryToken[aD]:=queryToken[aD]+substring2(queryToken[aD+1],0,1);
          queryToken[aD+1]:=substring(queryToken[aD+1],1);
        end;
      end;
    end;
    
    if (is_ssssat[aD]) then 
    begin
      llllM[aD]:=true;
    end;
    
    if (((UpperCase(databaseName)='SQL SERVER') 
      or  (UpperCase(databaseName)='MSACCESS')) 
      and not is_llllU[aD] 
      and not screenS[aD]) then 
    begin
      
      if (is_llllP[aD-1] 
        and not llllG[aD-1]) then 
      begin
        is_llllP[aD]:=true;
        isTokenQuoteLiterals[aD]:=true;
        
        if ((queryToken[aD]='[')) then 
        begin
          inc(i1);
        end;
        
        if ((queryToken[aD]=']') 
          and dec()=0) then 
        begin
          llllG[aD]:=true;
        end;
      end;
      
      if (not isTokenQuoteLiterals[aD] 
        and (queryToken[aD]='[')) then 
      begin
        inc(i1);
        is_ssssab[aD]:=true;
        is_llllP[aD]:=true;
      end;
      
      if (is_ssssat[aD]) then 
      begin
        llllG[aD]:=true;
      end;
      
      if (is_llllP[aD]) then 
      begin
        isTokenQuoteLiterals[aD]:=true;
      end;
    end;
    
    if (is_llll[aD-1] 
      and not llllI[aD-1]) then 
    begin
      is_llll[aD]:=true;
      isTokenQuoteLiterals[aD]:=true;
      
      if ((queryToken[aD]='"')) then 
      begin
        llllI[aD]:=true;
      end;
    end;
    
    if (not isTokenQuoteLiterals[aD] 
      and (queryToken[aD]='"')) then 
    begin
      is_ssssad[aD]:=true;
      is_llll[aD]:=true;
    end;
    
    if (is_ssssat[aD]) then 
    begin
      llllI[aD]:=true;
    end;
    
    if (is_llll[aD]) then 
    begin
      isTokenQuoteLiterals[aD]:=true;
    end;
    inc(aD);
  end;
end;


end.
