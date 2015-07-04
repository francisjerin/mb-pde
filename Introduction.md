PDE is used to detect software design pattern in Java software. There are a couple of steps that need to be done to detect design patterns.

## Dynamic facts ##
PDE needs dynamic facts from the software that is analyzed. These dynamic facts consist of a list of method calls that are executed during run-time of the software. To extract these dynamic facts the user needs to do the following:
  * Instrument your software using Probekit from the [Eclipse TPTP Project](http://www.eclipse.org/tptp/). We provide the probe (injected Java code) that is used for the instrumentation.
  * Please use our Probekit file to instrument the software you want to test. Download here [Instrumentation probe](http://mb-pde.googlecode.com/files/instrumentation.probe)
  * Execute the instrumented software (Test suites are very useful to generate good dynamic facts that are later used by our tool PDE).

![http://www.cse.yorku.ca/~mbirkner/website/images/wiki/new.jpg](http://www.cse.yorku.ca/~mbirkner/website/images/wiki/new.jpg) **Video Tutorial:** [Creating dynamic facts](http://video.google.ca/videoplay?docid=2879410788232427361&hl=en-CA) using Eclipse TPTP and the predefined [probekit script](http://mb-pde.googlecode.com/files/instrumentation.probe).


## Static facts ##
The static facts are extracted using the PDE software. PDE will call javex, grok and ql to extract and manipulate the static facts from the Class files of your software. To extract these static facts the user needs to do the following:
  * install javex, grok and ql on your Linux system (see below)
  * edit the **software.xml** file and edit the execution links for javex, grok and ql according to your system. Also add the name and location of the software that you are testing in this XML file.
  * Run PDE to extract all static facts. PDE will create files with the possible candidate instances of design pattern. These files are used as input for PDE for the dynamic analysis.

` java -jar pde3.jar -static `


## Dynamic analysis ##
The dynamic analysis uses the static and dynamic facts as well as dynamic definitions of the design patterns to verify the possible candidate instances.
  * The dynamic definitions of the design patterns are stored in the **designpatterns.xml** file.
  * Adjust the location for the dynamic facts and static facts (candidate instances). The default values should work if you did not change the locations in any previous steps.
  * Run the dynamic analysis:

` java -jar pde3.jar -input pde.input -ps -threshold 0.8 `

## End ##
The output of PDE can be adjusted, depending on the level of information you require. Please check the "help" command of PDE for more detailed information.

` java -jar pde3.jar -help `


## Prerequisites ##

![http://www.cse.yorku.ca/~mbirkner/website/images/wiki/alert.gif](http://www.cse.yorku.ca/~mbirkner/website/images/wiki/alert.gif)  Note: In order to run PDE, the following things need to be installed
  * Static fact extraction: SWAG toolkit from the University of Waterloo. We make use of javex, grok and ql from the toolkit to extract static facts from the Java software that is analyzed. The toolkit can be downloaded [here](http://www.swag.uwaterloo.ca/swagkit/index.html). The user of PDE does not need any knowledge about javex, grok and ql. PDE will take care of executing the tools when needed.
  * Dynamic fact extraction: In order to extract dynamic facts from the Java software we use the TPTP Plugin for Eclipse, see [Eclipse Plugin TPTP](http://www.eclipse.org/tptp/). We provide a probe for TPTP that will instrument the code so that the result is stored in a format the PDE is able to use.

## Installation of PDE ##

  1. Download the software using [svn (Subversion)](http://en.wikipedia.org/wiki/Subversion_(software)) (including source code). Non-members may check out a read-only working copy anonymously over HTTP.
> > ` svn checkout http://mb-pde.googlecode.com/svn/trunk/ mb-pde `
  1. To see the possible input parameters type:
> > ` java -jar pde3.jar -usage `
  1. To run the static analysis type:
> > ` java -jar pde3.jar -static `
  1. To run the dynamic analysis type:
> > ` java -jar pde3.jar -input input.pde -ps -threshold 0.8 `


## Installation of TPTP ##

To install TPTP packages using the Eclipse Update Manager:
  1. From the Help menu in Eclipse, select Software Updates > Find and Install.
  1. Select the Search for new features to install radio button. Click Next.
  1. Add a new update site by clicking on New Remote Site.
  1. Enter the following name and URL and click OK:
> > - Name: TPTP Update site
> > - URL: http://eclipse.org/tptp/updates/site.xml
  1. Click Finish.
  1. In the "Search Results" dialog box, select the features to install. Then click Next.
  1. In the "Feature License" dialog box, accept the license and click Next.
  1. In the "Installation" dialog box, verify the features to be installed and change install location if necessary. Then click Finish.
  1. After you click Finish, you will be presented a confirmation about a digital signature. Click Install All.
  1. When done, restart your workbench.

For more information please visit the Eclipse TPTP Project site http://www.eclipse.org/tptp/home/downloads/installguide/InstallGuide44.html


## Installation of Javex, Grok and QL (SWAG toolkit) ##

![http://www.cse.yorku.ca/~mbirkner/website/images/wiki/new.jpg](http://www.cse.yorku.ca/~mbirkner/website/images/wiki/new.jpg)
For the installation of these three tools please refer to the [website](http://www.swag.uwaterloo.ca/swagkit/index.html). These three tools can only be deployed under Linux. Therefore we suggest to install and setup PDE under a Linux environment so that the files do not need to be copied from one environment to another.