# This is a quick Makefile to make this module compile.
# Serguei Mokhov
#
# $Header: /cvsroot/marf/marf/src/marf/math/Makefile,v 1.4 2006/04/27 13:27:09 mokhov Exp $
#

BASE_MARF_DIR = ../..

include $(BASE_MARF_DIR)/../Makefile.global

JAVAC = javac
CLASSPATH = .
JFLAGS = $(COMMONJFLAGS) -classpath $(CLASSPATH) -sourcepath $(BASE_MARF_DIR) #-verbose -Xlint:unchecked

CLASSFILES = \
	Algorithms.class \
	MathException.class \
	Matrix.class \
	Vector.class \
	ComplexNumber.class \
	ComplexMatrix.class \
	ComplexVector.class

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $<

all: $(CLASSFILES)

Algorithms.class: Algorithms.java
MathException.class: MathException.java
Matrix.class: Matrix.java
Vector.class: Vector.java
ComplexNumber.class: ComplexNumber.java
ComplexMatrix.class: ComplexMatrix.java
ComplexVector.class: ComplexVector.java

clean:
	rm -f $(CLASSFILES) *.class

maintainer-clean: clean
	rm -f *.log *.diff

# EOF
