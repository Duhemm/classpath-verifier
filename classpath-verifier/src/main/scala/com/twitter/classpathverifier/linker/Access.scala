package com.twitter.classpathverifier.linker

import org.objectweb.asm.Opcodes

case class Access(rawValue: Int) {
  def isPublic: Boolean = (rawValue & Opcodes.ACC_PUBLIC) != 0
  def isPrivate: Boolean = (rawValue & Opcodes.ACC_PRIVATE) != 0
  def isProtected: Boolean = (rawValue & Opcodes.ACC_PROTECTED) != 0
  def isAbstract: Boolean = (rawValue & Opcodes.ACC_ABSTRACT) != 0
  def isStatic: Boolean = (rawValue & Opcodes.ACC_STATIC) != 0
}

object Access {
  val Empty: Access = Access(0)
  val PublicClass: Access = Access(Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER)
  val PublicInterface: Access = Access(
    Opcodes.ACC_PUBLIC | Opcodes.ACC_INTERFACE | Opcodes.ACC_ABSTRACT
  )
  val PublicAbstractClass: Access = Access(
    Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_ABSTRACT
  )
  val PublicObject: Access = Access(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL | Opcodes.ACC_SUPER)

  val PublicMethod: Access = Access(Opcodes.ACC_PUBLIC)
  val PrivateMethod: Access = Access(Opcodes.ACC_PRIVATE)
  val PublicAbstractMethod: Access = Access(Opcodes.ACC_PUBLIC | Opcodes.ACC_ABSTRACT)
  val PublicStaticMethod: Access = Access(
    Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC | Opcodes.ACC_FINAL | Opcodes.ACC_SYNTHETIC
  )
  val PrivateStaticSyntheticMethod: Access = Access(
    Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC | Opcodes.ACC_SYNTHETIC
  )
  val Clinit: Access = Access(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
}
