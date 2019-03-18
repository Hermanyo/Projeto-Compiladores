unit Main;

interface

uses
  StrUtils, SysUtils, StringTokenizer;

type
  TMain=class
  private
    procedure main(args : String);
    function createOutput(code : Semantico; fileName : String): String;
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

{ TMain }

constructor TMain.Create();
begin
  inherited Create;
end;

destructor TMain.Destroy();
begin
  inherited Destroy;
end;

procedure TMain.main(args : String);
var
  tree : Start;
  tm : TokenMapper;
  arquivo : String;
  p : Parser;
  wout : Writer;
  AnaliseSemantica : Semantico;
  fileName : String;
begin
  arquivo:='/home/hermanyo/NetBeansProjects/projeto_compiladores/dist/expressao.calc';
  ~~~~~5
  ~~~~~5
  ~~~~~5
  ~~~~~5
  p:=######7;
  tree:=p.parse();
  ~~~~~5
  tm:=######7;
  tree.apply(tm);
  ~~~~~5
  AnaliseSemantica:=######7;
  tree.apply(AnaliseSemantica);
  AnaliseSemantica.printSymbolTable();
  fileName:='Tesaurus';
  
  wout:=######7;
  wout.append(createOutput(AnaliseSemantica,fileName));
  wout.close();
end;

function TMain.createOutput(code : Semantico; fileName : String): String;
var
  size : integer;
begin
  size:=code.getBlOCOS().size();
  result := '.bytecode 50.0\n'+'.class public '+fileName+#10+'.super java/lang/Object\n'+'.method public <init>()V\n'+'\t.limit stack 1\n'+'\t.limit locals 1\n'+'\taload_0\n'+'\tinvokespecial java/lang/Object/<init>()V\n'+'\treturn\n'+'.end method\n'+'\t.method public static main([Ljava/lang/String;)V\n'+'\t.limit stack '+code.scope()+#10+'asasdassaddsdquhe12y8h1u2h87g78hu8syd78'+'\t.limit locals '+size+#10+'\treturn\n'+'.end method\n';
end;


end.
