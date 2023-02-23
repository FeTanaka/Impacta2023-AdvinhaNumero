package br.com.impacta.curso.impacta2023_advinhanumero

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.impacta.curso.impacta2023_advinhanumero.databinding.FragmentInicialBinding
import kotlin.random.Random


class InicialFragment : Fragment() {

    private var _binding: FragmentInicialBinding? = null
    private val binding get() = _binding!!
    private val args: InicialFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInicialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("IMPACTA", "numeroArgs: ${args.numeroSorteado}")

        val numeroSorteado = if (args.numeroSorteado != -1) {
            args.numeroSorteado
        } else {
            Random.nextInt(0, 10)
        }
        Log.d("IMPACTA2", "numeroSorteado: $numeroSorteado")

        binding.button.setOnClickListener {
            try {
                val inputUsuario = binding.editTextNumber.text.toString().toInt()

                val acao = when {
                    inputUsuario > numeroSorteado -> InicialFragmentDirections.actionInicialFragmentToChuteMaiorFragment(numeroSorteado)
                    inputUsuario < numeroSorteado -> InicialFragmentDirections.actionInicialFragmentToChuteMenorFragment(numeroSorteado)
                    else -> InicialFragmentDirections.actionInicialFragmentToParabensFragment()
                }

                findNavController().navigate(acao)
            } catch (e: java.lang.NumberFormatException) {
                binding.editTextNumber.error = getString(R.string.nao_digitou_numero)
            }
        }
    }


}