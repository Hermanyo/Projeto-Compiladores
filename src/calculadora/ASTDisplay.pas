unit ASTDisplay;

interface

uses
  StrUtils, SysUtils, StringTokenizer;

type
  TASTDisplay=class
  private
    parents : Stack;
    procedure outStart(node : Start);
    procedure windowClosing(e : WindowEvent);
    procedure defaultIn(node : Node);
    procedure defaultOut(node : Node);
    procedure defaultCase(node : Node);
    procedure caseEOF(node : EOF);
    procedure expandAll(tree : JTree);
    procedure expandAll(tree : JTree; path : TreePath);
    function extremalPaths(data : TreeModel; path : TreePath; result : Collection): Collection;
    procedure extremalPathsImpl(data : TreeModel; path : TreePath; result : Collection);
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

{ TASTDisplay }

constructor TASTDisplay.Create();
begin
  inherited Create;
end;

destructor TASTDisplay.Destroy();
begin
  inherited Destroy;
end;

~~~~~5
begin
end;
procedure TASTDisplay.outStart(node : Start);
var
  tree : JTree;
  frame : JFrame;
  pane : JScrollPane;
begin
  ~~~~~5
  frame:=######7;
  ~~~~~5
  tree:=######7;
  ~~~~~5
  pane:=######7;
  expandAll(tree);
procedure TASTDisplay.windowClosing(e : WindowEvent);
  begin
    System.exit(0);
  end;
  
  end.
  ~~~~~5
  frame.addWindowListener(######7);
  frame.setSize(300,400);
  frame.getContentPane().add(pane);
  frame.setVisible(true);
end;

procedure TASTDisplay.defaultIn(node : Node);
var
  thisNode : DefaultMutableTreeNode;
begin
  ~~~~~5
  thisNode:=######7;
  parents.push(thisNode);
end;

procedure TASTDisplay.defaultOut(node : Node);
var
  thisNode : DefaultMutableTreeNode;
begin
  thisNode:=###########4;
  (###########4).add(thisNode);
end;

procedure TASTDisplay.defaultCase(node : Node);
var
  thisNode : DefaultMutableTreeNode;
begin
  ~~~~~5
  thisNode:=######7;
  (###########4).add(thisNode);
end;

procedure TASTDisplay.caseEOF(node : EOF);
begin
end;

procedure TASTDisplay.expandAll(tree : JTree);
var
  root : Object;
begin
  root:=tree.getModel().getRoot();
  
  if (root<>nil) then 
  begin
    ~~~~~5
    expandAll(tree,######7);
  end;
end;

procedure TASTDisplay.expandAll(tree : JTree; path : TreePath);
var
  i : Iterator;
begin
  ~~~~~5
  i:=extremalPaths(tree.getModel(),path,######7).iterator();
  while (i.hasNext()) do begin
    tree.expandPath(###########4);
    ;
  end;
end;

function TASTDisplay.extremalPaths(data : TreeModel; path : TreePath; result : Collection): Collection;
begin
  result.clear();
  
  if (data.isLeaf(path.getLastPathComponent())) then 
  begin
    result := result;
  end;
  extremalPathsImpl(data,path,result);
  result := result;
end;

procedure TASTDisplay.extremalPathsImpl(data : TreeModel; path : TreePath; result : Collection);
var
  i : integer;
  count : integer;
  node : Object;
  hasNonLeafChildren : boolean;
  child : Object;
begin
  node:=path.getLastPathComponent();
  hasNonLeafChildren:=false;
  count:=data.getChildCount(node);
  i:=0;
  while (i<count) do begin
    
    if (not data.isLeaf(data.getChild(node,i))) then 
    begin
      hasNonLeafChildren:=true;
    end;
    inc(i);
  end;
  
  if (not hasNonLeafChildren) then 
  begin
    result.add(path);
  end else begin
    i:=0;
    while (i<count) do begin
      child:=data.getChild(node,i);
      
      if (not data.isLeaf(child)) then 
      begin
        extremalPathsImpl(data,path.pathByAddingChild(child),result);
      end;
      inc(i);
    end;
  end;
end;


end.
