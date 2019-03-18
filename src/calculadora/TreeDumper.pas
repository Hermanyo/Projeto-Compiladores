unit TreeDumper;

interface

uses
  StrUtils, SysUtils, StringTokenizer;

type
  TTreeDumper=class
  private
    out : PrintWriter;
    depth : integer;
    procedure defaultCase(node : Node);
    procedure defaultIn(node : Node);
    procedure defaultOut(node : Node);
    procedure printNodeName(node : Node);
    procedure indent();
    procedure main(args : String);
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

{ TTreeDumper }

constructor TTreeDumper.Create();
begin
  inherited Create;
end;

destructor TTreeDumper.Destroy();
begin
  inherited Destroy;
end;

begin
  ~~~~~2
  this.out:=out;
end;
procedure TTreeDumper.defaultCase(node : Node);
begin
  indent();
  out.println((###########4).getText());
end;

procedure TTreeDumper.defaultIn(node : Node);
begin
  indent();
  printNodeName(node);
  out.println();
  depth:=depth+1;
end;

procedure TTreeDumper.defaultOut(node : Node);
begin
  depth:=depth-1;
  out.flush();
end;

procedure TTreeDumper.printNodeName(node : Node);
var
  name : String;
  fullName : String;
begin
  fullName:=node.getClass().getName();
  name:=substring(fullName,fullName.lastIndexOf('.')+1);
  out.print(name);
end;

procedure TTreeDumper.indent();
var
  i : integer;
begin
  i:=0;
  while (i<depth) do begin
    out.write('   ');
    inc(i);
  end;
end;

procedure TTreeDumper.main(args : String);
var
  expr : String;
  start : Start;
  parser : Parser;
begin
  expr:=if (args.length=0) then '(1+2)*3' args[0];
  ~~~~~5
  ~~~~~5
  ~~~~~5
  ~~~~~5
  parser:=######7;
  begin
    start:=parser.parse();
    ~~~~~5
    ~~~~~5
    start.getPPrograma().apply(######7);
  end;
  begin
    e.printStackTrace();
    System.exit(1);
  end;
end;


end.
