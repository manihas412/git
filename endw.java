package com.gm.rhp.di.systems.systemDesign;
import java.nio.file.Path;(]

public class ECUNodeDataliriter extends RhpWriter

{
private final static Logger LOGGER = LogManager.getLogger (SystenSignalTypeWriter class. gytSimpleName());

protected IRPClass rhpGmObject;

protected IRPPackage owningPackage;

//protected final ECUNodeData gmObject;

protected ECUNodeData oldGmObject;

protected List< ECUNodeData> gmObject = new ArrayList<ECUNodeData>();

public ECUNodeDataliriter (final RhpAppInstance requestingInstance, final List< ECUNodeData> gmObject)

{
super (requestingInstence) ;
this.gmObject = gnObject;
oldGmObject = null;
I
private void write() throws ModelTransactionException
t
//try
MK

boolean duplicatetxist = false;

*****************************************************************************
throw new ModelTransactionException(Result .DUPLICATE_CHECKER_QUERY_RESULTS_ALREADY_EXISTS.toString()) 3
3

IRPInstance rpECU = ( IRPInstance )MDKScriptBase.findELement( owningPackage, ecuNlame, "Part" );
if( rpECU != null )

{

 

fireTransactionEvent( "ECU with the same name already exists '" + eBione ee
continue;

if( rpECU == null )

ECUNodeData m_selectedECU = null;
for(ECUNodeData m_allECU : gmObject)
{
if (m_allECU. getName().equals(name))
{
m_selectedECU = new ECUNodeData(name, m_allECU.getGuid());
//m_selectedECU. setGUID(m_allECU.getGUID()) ;
m_selectedECU. setOwnerHierarchy(m_allECU.getOwnerHierarchy());
//m_selectedECU. setUnitPath (m_allECU.getUnitPath());
m_selectedECU. setPath(m_allECU.getPath());
break;

}

String guid = "GUID "+ m_selectedECU.getGuid() ;
IRPClass otherCls = (IRPClass) project. findElementByGUID(guid) ;
************************************************************************************

String guid = "GUID "+ m_selectedECU.getGuid() ; h
IRPClass otherCls = (IRPClass) project. findElementByGUID (guid);

if( otherCls
{

 

null)

String HierarchyLevel[] = m_selectedECU.getOwnerHierarchy();
for ( String hierarchy : HierarchyLevel)
€
hierarchy = hierarchy.replaceAll("\\:
String[] unitpath = hierarchy.split(",");
IFileReferenceTask missingFileRef = AssetManagementInfrastructure.getIAssetManager() .getFileForReference(unitpath[unit
Path path=null;
try {
path = missingFileRef.getResult();
} catch (SFSException e) {
// TODO Auto-generated catch block
e.printStackTrace();

 

if(path ==null )
4

throw new ModelTransactionException(" Can not add " + m_selectedECU.getName() );

************************************************************************************************


= null ) RhpSystemsDI/src/com/gm/thp/di/systems/systemDesign/ECU
throw new ModelTransactionException(” Can not add " + m_selectedECulgetName() );

}
3

StringBuilder combinedStringBuilder = new StringBuilder();
combinedStringBuilder.append('[');
for (String str: m_selectedECU.getOwnerHierarchy()) {
combinedStringBuilder.append('[");
combinedStringBuilder.append(str) ;
combinedStringBuilder.append(']');
combinedStringBuilder.append(',');
e
comb inedStringBuilder.. setLength(combinedStringBuilder. length()-2)
combinedStringBuilder.append(']');
combinedStringBuilder.append(']');
OuningDetailsInterpreter interpreter = new OuningDetailsInterpreter(conbinedStringBuilder.toString());

 

String modelPath = "";
for (OuningDetailsEntry entry : interpreter.getOwningList()) {
modelPath = modelPath.concat(entry.name) ;
modelPath = modelPath.concat("::");
3

modelPath = modelPath.substring(@, modelPath.length()-2);
editInstance.findElementsByFulName(nodelPath, “Package");
editInstance.findElementsByFullName(nodelPath, “class");

 

otherCls = (IRPClass) project. findElementByGUID(guid) ;
if(otherCls == null)
t

2
IRPPackage testPkg = (IRPPackage) MDKScriptBase.findElement( project, "Testi", "Package", RecursiveFind.NO)

if(testPkg == null)
testPkg = project.addPackage("Test1");

throw new ModelTransactionException(" Can not find " + m_selectedECU.getName() )5

IRPClass rpClass = (IRPClass) MDKScriptBase.findElement( testPkg, "Test2", "Class", RecursiveFind.NO)
if(rpClass == null)
rpClass =testPkg.addClass("Test2");


 **********************************************************************************************
  

null)
testPkg.addClass("Test2");

if(rpClass
rpClass

rpClass.setOwner(testPkg);

rpECU = (IRPInstance) rpClass.addNewAggr("Pert", ecullame) ;

   

 

editInstance.addStereotypeToModelElement(rpECU, “MDK_Reference_Pkg: :DepArchTerms: :ECU_Node") ;
if( rpECU == null )
{

throw new ModelTransactionException(Result .CAN_NOT_CREATE_PART.toString())5
}

rpECU.setOtherClass( otherCls );
rpECU. setSpparateSaveUnit (1) ;
rpECU. setOkher (owningPackage) ;
testPkg. setSeparateSaveUnit(1) ;
testPkg-unload() ;
testPkg.deleteFromProject();

}
+

/T}

//catch ( Exception e )
“7 i

ty
+
@0verride

public void write(String editHandleGUID) throws ModelTransactionException {
if(task == null)

t
task = new RhpModelWriteTransactionTask(requestingInstance, editHandleGUID, new ECUNodeDataliriterTask(), false);
task.startTask();
task.waitForTaskCompletion() ;

+

throwTaskException() ;


****************************************************************************************
throwTaskException(};

}

private class ECUNodeDataliriterTask implements IWriteModelTransactionRunnable

{

@0verride
public void modelTransactionOperation(RhpAppInstance editInstance, IRPModelElement editHandle)
throws ModelTransactionException {
sethiriterEditInstance(editInstance) ;
owningPackage = (IRPPackage) editHandle ;
write();






 

