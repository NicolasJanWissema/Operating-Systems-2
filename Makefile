JFLAGS = -g -d $(BINDIR)/ -cp $(BINDIR)
CLASSPATH = $(BINDIR)
SRCDIR=src
BINDIR=bin
DOCDIR=doc

.SUFFIXES: .java .class


$(SRCDIR)/%.class:$(SRCDIR)/%.java
	javac $(JFLAGS) $<

CLASSES= molecule/BarrierReusable.class \
	molecule/Propane.class \
	molecule/Carbon.class \
	molecule/Hydrogen.class \
	molecule/RunSimulation.class \
	Synchronization.class

CLASS_FILES=$(CLASSES:%.class=$(SRCDIR)/%.class)

default: $(CLASS_FILES)

run: $(CLASS_FILES)
	java -cp $(CLASSPATH) Synchronization $(ARGS)

docs:
	javadoc -cp $(CLASSPATH) - $(DOCDIR) $(SRCDIR)/*.java

clean:
	rm $(BINDIR)/*.class

cleandocs:
	rm $(DOCDIR)/*