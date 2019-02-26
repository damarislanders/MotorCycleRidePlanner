document.querySelectorAll('textarea').forEach(a => {
  const updateHeight = () => {
    a.style.height = '0'
    a.style.height = `${a.scrollHeight}px`
  }
  a.style.overflow = 'hidden'
  updateHeight()
  a.addEventListener('input', updateHeight)
})
