JFLAGS = -g -d $(BINDIR)/ -cp $(BINDIR)
CLASSPATH = $(BINDIR)
SRCDIR=src
BINDIR=bin
DOCDIR=docs

.SUFFIXES: .java .class


$(SRCDIR)/%.class:$(SRCDIR)/%.java
	javac $(JFLAGS) $<

CLASSES= molecule/BarrierReusable.class \
	molecule/Propane.class \
	molecule/Carbon.class \
	molecule/Hydrogen.class \
	molecule/RunSimulation.class \
	SafetyCheckRun.class

CLASS_FILES=$(CLASSES:%.class=$(SRCDIR)/%.class)

default: $(CLASS_FILES)

run:
	java -cp $(CLASSPATH) SafetyCheckRun $(ARGS)

docs:
	javadoc -cp $(CLASSPATH) - $(DOCDIR) $(SRCDIR)/*.java

clean:
	rm $(BINDIR)/*.class

cleandocs:
	rm $(DOCDIR)/*